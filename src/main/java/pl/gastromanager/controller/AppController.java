package pl.gastromanager.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.gastromanager.model.*;
import pl.gastromanager.service.*;
import pl.gastromanager.util.OrderMealsUtils;
import pl.gastromanager.util.OrderUtils;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/app")
public class AppController {
    private final PaymentsService paymentsService;
    private final UserService userService;
    private final MealService mealService;
    private final DietService dietService;
    private final PlanService planService;
    private final WeekDaysService weekDaysService;
    private final MealNameService mealNameService;
    private final OrderUtils orderUtils;
    private final OrderMealsUtils orderMealsUtils;
    private final PlansMealsService plansMealsService;
    private final OrdersService ordersService;


    public AppController(PaymentsService paymentsService, UserService userService, MealService mealService, DietService dietService, PlanService planService, WeekDaysService weekDaysService, MealNameService mealNameService, OrderUtils orderUtils, OrderMealsUtils orderMealsUtils, PlansMealsService plansMealsService, OrdersService ordersService) {
        this.paymentsService = paymentsService;
        this.userService = userService;
        this.mealService = mealService;
        this.dietService = dietService;
        this.planService = planService;
        this.weekDaysService = weekDaysService;
        this.mealNameService = mealNameService;
        this.orderUtils = orderUtils;
        this.orderMealsUtils = orderMealsUtils;
        this.plansMealsService = plansMealsService;
        this.ordersService = ordersService;
    }


    //Method from MealController
    @GetMapping("/meal/list")
    public String listMeal(Model model) {
        model.addAttribute("meals", mealService.findAll());
        return "meal/showAllMeals";
    }

    @GetMapping("/meal/details/{id}")
    public String showMealDetails(@PathVariable Long id, Model model) {
        Meal meal = mealService.findMealById(id);
        model.addAttribute("meal", meal);
        return "meal/showDetails";
    }

    //Method from PlanController

    @RequestMapping("/plan/all")
    public String getAllPlans(Model model) {
        model.addAttribute("plans", planService.findAll());
        return "plan/all";
    }

    @RequestMapping("/plan/{id}")
    public String getPlan(@PathVariable("id") Long id, Model model) {
        model.addAttribute("plan", planService.findById(id));
        model.addAttribute("weekDays", weekDaysService.findAll());
        model.addAttribute("mealNames", mealNameService.findAll());
        model.addAttribute("plansMeals", new PlansMeals());

        return "plan/showDetails";
    }

    //Method to do ShoppingCart Operations
    @GetMapping("/shoppingCartDropItem/{index}")
    public String showShoppingItems(
            @SessionAttribute("shoppingCart") Orders shoppingCart,
            @PathVariable int index,
            HttpServletRequest request
    ) {
        List<OrderMeals> shoppingItems = shoppingCart.getOrderMeals();
        shoppingItems.remove(index);
        shoppingCart.setOrderMeals(shoppingItems);
        shoppingCart.setOrderPrice(orderUtils.countTotalPrice(shoppingCart));

        String referer = request.getHeader("Referer");

        return "redirect:" + referer;
    }

    //---------------Order Meal-----------------
    @GetMapping("/orders/addCart/mealName")
    public String addMealNameGet(Model model) {
        model.addAttribute("mealNames", mealNameService.findAll());
        model.addAttribute("mealName", new MealName());
        return "orders/addMealName";
    }

    @PostMapping("/orders/addCart/mealName")
    public String addMealNamePost(MealName mealName) {
        return "redirect:/app/orders/addCart/mealName/meal/" + mealName.getId();
    }

    @GetMapping("/orders/addCart/mealName/meal/{id}")
    public String addMealGet(@PathVariable Long id, Model model) {
        MealName mealName = mealNameService.findById(id);
        model.addAttribute("mealName", mealName);
        model.addAttribute("meals", mealService.findAllMealsByMealName(mealName));
        model.addAttribute("plansMeals", new PlansMeals());
        return "orders/addMealToPlansMeals";
    }

    @PostMapping("/orders/addCart/mealName/meal")
    public String addMealPost(
            PlansMeals plansMeals,
            @RequestParam("quantity") Long quantity,
            @SessionAttribute("shoppingCart") Orders shoppingCart,
            HttpServletRequest request
    ) {
        List<OrderMeals> shoppingItems = shoppingCart.getOrderMeals() == null ? new ArrayList<>() : shoppingCart.getOrderMeals();
        PlansMeals firstByMealAndMealName = plansMealsService.findFirstByMealAndMealName(plansMeals.getMeal(), plansMeals.getMealName());
        List<PlansMeals> plansMealsList = List.of(firstByMealAndMealName);

        OrderMeals orderMeals = new OrderMeals();
        orderMeals.setPlansMeals(plansMealsList);
        orderMeals.setQuantity(quantity);
        orderMeals.setName(firstByMealAndMealName.getMeal().getName());
        orderMeals.setPrice(orderMealsUtils.getPriceByMeals(orderMeals));
        orderMeals.setOrderType(OrderType.MEAL);
        shoppingItems.add(orderMeals);
        shoppingCart.setOrderMeals(shoppingItems);
        shoppingCart.setOrderPrice(orderUtils.countTotalPrice(shoppingCart));

        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    //---------Order Day from Plan--------
    @PostMapping("/orders/addCart/selectPlan/selectDay")
    public String selectDayGet(
            PlansMeals plansMeals,
            @SessionAttribute("shoppingCart") Orders shoppingCart,
            @RequestParam("quantity") Long quantity,
            HttpServletRequest request
    ) {
        List<OrderMeals> shoppingItems = shoppingCart.getOrderMeals() == null ? new ArrayList<>() : shoppingCart.getOrderMeals();
        List<PlansMeals> planMealsList = plansMealsService.findAllByPlanAndWeekDays(plansMeals.getPlan(), plansMeals.getWeekDays());

        String name = plansMeals.getWeekDays().getName() + " z " +
                plansMeals.getPlan().getName();

        OrderMeals orderMeals = new OrderMeals();
        orderMeals.setPlansMeals(planMealsList);
        orderMeals.setName(name);
        orderMeals.setQuantity(quantity);
        orderMeals.setOrderType(OrderType.PLANDAY);
        orderMeals.setPrice(orderMealsUtils.getPriceByMeals(orderMeals));
        shoppingItems.add(orderMeals);
        shoppingCart.setOrderMeals(shoppingItems);
        shoppingCart.setOrderPrice(orderUtils.countTotalPrice(shoppingCart));

        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    //--------Order Plan---------------
    @PostMapping("/orders/addCart/plan")
    public String addPlanPost(
            PlansMeals plansMeals,
            @SessionAttribute("shoppingCart") Orders shoppingCart,
            @RequestParam("quantity") Long quantity
    ) {
        List<OrderMeals> shoppingItems = shoppingCart.getOrderMeals() == null ? new ArrayList<>() : shoppingCart.getOrderMeals();
        List<PlansMeals> plansMealsList = plansMealsService.findAllByPlan(plansMeals.getPlan());
        OrderMeals orderMeals = new OrderMeals();
        orderMeals.setPlansMeals(plansMealsList);
        orderMeals.setOrderType(OrderType.PLAN);
        orderMeals.setQuantity(quantity);
        orderMeals.setName(plansMeals.getPlan().getName());
        orderMeals.setPrice(orderMealsUtils.getPriceByPlan(orderMeals));
        shoppingItems.add(orderMeals);
        shoppingCart.setOrderMeals(shoppingItems);
        shoppingCart.setOrderPrice(orderUtils.countTotalPrice(shoppingCart));

        return "redirect:/app/plan/all";
    }

    //shoppingCartView
    @GetMapping("/shoppingCart/details")
    public String shoppingCartView(Model model, @SessionAttribute("shoppingCart") Orders shoppingCart) {
        model.addAttribute("order", new Orders());
        model.addAttribute("orderTypeMeal", OrderType.MEAL);
        return "orders/add";
    }

    @PostMapping("/shoppingCart/saveOrder")
    public String saveOrder(Orders order, Model model, @SessionAttribute("shoppingCart") Orders shoppingCart, Authentication authentication) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String fromDateS = order.getFromDate();
        String toDateS = order.getToDate();

        long days;
        LocalDate fromDate = LocalDate.parse(fromDateS, df);
        LocalDate toDate = LocalDate.parse(toDateS, df);
        days = ChronoUnit.DAYS.between(fromDate, toDate);

        LocalDateTime now = LocalDateTime.now();

        shoppingCart.setFromDate(fromDateS);
        shoppingCart.setToDate(toDateS);
        shoppingCart.setOperationDate(dtf.format(now));

        Users user = userService.findByUserEmail(authentication.getName());

        Payments payments = new Payments();
        LocalDateTime expiredTime = now.plusDays(days + 14);
        String expiredTimeS = dtf.format(expiredTime);

        payments.setFinalPayDate(expiredTimeS);
        payments.setSummaryPrice((float) Math.round(shoppingCart.getOrderPrice() * days * 100) / 100);
        payments.setUsers(user);
        payments.setPayed(false);

        Orders newOrder = new Orders();
        newOrder.setOrderMeals(shoppingCart.getOrderMeals());
        newOrder.setOrderPrice(shoppingCart.getOrderPrice());
        newOrder.setFromDate(shoppingCart.getFromDate());
        newOrder.setToDate(shoppingCart.getToDate());
        newOrder.setOperationDate(shoppingCart.getOperationDate());

        payments.setOrders(newOrder);

        ordersService.addOrders(newOrder);
        paymentsService.addPayments(payments);

        shoppingCart.setOrderMeals(new ArrayList<>());
        return "redirect:/home";
    }

    //Method from OrdersController
    @GetMapping("/user/{userId}/orders/all")
    public String showAllMyOrders(Model model,@PathVariable Long userId, Authentication auth, HttpServletRequest request){
        Users currentUser = userService.findByUserEmail(auth.getName());
        Users user = userService.get(userId);
        model.addAttribute("user", user);
        model.addAttribute("currentUser", currentUser);

        List<Payments> payments = paymentsService.findPaymentsByUserId(userId);
        model.addAttribute("payments", payments);
        return "payments/userOrderList";
    }

    @GetMapping("/user/{userId}/orders/details/{paymentId}")
    public String showUsersOrderDetails(
            @PathVariable Long userId,
            @PathVariable Long paymentId,
            Model model,
            Authentication auth
    ){
        Payments payment = paymentsService.getPayment(paymentId);
        Users user = userService.get(userId);
        model.addAttribute("payment", payment);
        model.addAttribute("user", user);
        model.addAttribute("orderTypeMeal", OrderType.MEAL);
        model.addAttribute("newPayment", new Payments());
        return "payments/userOrderDetails";
    }

    @PostMapping("/user/{userId}/orders/all")
    public String payForOrder(Payments payments, HttpServletRequest request){
        Payments payment = paymentsService.getPayment(payments.getId());
        payment.setPayed(true);
        paymentsService.editPayment(payment);
        String referer = request.getHeader("Referer");
        return "redirect:"+referer;
    }

    //--------------User-------------
    //Dla zalogowanego użytkownika
    @RequestMapping(value = "user/edit")
    public String editUser (Model model, Authentication auth){
        Users currentUser = userService.findByEmail(auth.getName());
        Long id = currentUser.getId();
        model.addAttribute("user", userService.get(id));
        return "user/editUser";
    }

    @RequestMapping(value = "user/update", method = RequestMethod.POST)
    public String saveEditUser (@Valid @ModelAttribute ("user") Users user, BindingResult result){
        if(result.hasErrors()){
            return "user/editUser";
        }
        userService.add(user);
        return "redirect:/home";
    }
    @RequestMapping(value = "user/biling")
    public String biling(){
        return "user/Biling";

    }
    @RequestMapping(value = "user/security")
    public String security(){
        return "user/Security";

    }





}
