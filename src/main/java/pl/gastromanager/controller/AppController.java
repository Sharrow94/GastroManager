package pl.gastromanager.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gastromanager.model.*;
import pl.gastromanager.service.*;
import pl.gastromanager.util.OrderMealsUtils;
import pl.gastromanager.util.OrderUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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


    public AppController(PaymentsService paymentsService, UserService userService, MealService mealService, DietService dietService, PlanService planService, WeekDaysService weekDaysService, MealNameService mealNameService, OrderUtils orderUtils, OrderMealsUtils orderMealsUtils, PlansMealsService plansMealsService) {
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
    }

    //Method from PaymentsController
    @RequestMapping("/payments/all")
    public String showAllPayments(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users currentUser = userService.findByUserName(auth.getName());
        Long id = currentUser.getId();
        List<String> roles = paymentsService.findAllRolesByUserId(id);
        if (roles.contains("ROLE_ADMIN")) {
            List<Payments> paymentsAll = paymentsService.findAllPayments();
            model.addAttribute("payments", paymentsAll);
        } else {
            List<Payments> payments = paymentsService.findPaymentsByUserId(id);
            model.addAttribute("payments", payments);
        }
        return "payments/list";
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
    ){
        List<OrderMeals> shoppingItems = shoppingCart.getOrderMeals();
        shoppingItems.remove(index);
        shoppingCart.setOrderMeals(shoppingItems);
        shoppingCart.setOrderPrice(orderUtils.countTotalPrice(shoppingCart));

        String referer = request.getHeader("Referer");

        return "redirect:"+referer;
    }

    //---------------Order Meal-----------------
    @GetMapping("/orders/addCart/mealName")
    public String addMealNameGet(Model model, @SessionAttribute("shoppingCart") Orders orders) {
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
        List<PlansMeals> plansMealsList = List.of(plansMeals);

        OrderMeals orderMeals = new OrderMeals();
        orderMeals.setPlansMeals(plansMealsList);
        orderMeals.setQuantity(quantity);
        orderMeals.setName(plansMeals.getMeal().getName());
        orderMeals.setPrice(orderMealsUtils.getPriceByMeals(orderMeals));
        orderMeals.setOrderType(OrderType.MEAL);
        shoppingItems.add(orderMeals);
        shoppingCart.setOrderMeals(shoppingItems);
        shoppingCart.setOrderPrice(orderUtils.countTotalPrice(shoppingCart));

        String referer = request.getHeader("Referer");
        return "redirect:"+referer;
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
        return "redirect:"+referer;
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



    //Method from OrdersController




}
