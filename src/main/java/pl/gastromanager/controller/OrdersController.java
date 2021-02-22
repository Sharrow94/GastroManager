package pl.gastromanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gastromanager.model.*;
import pl.gastromanager.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    private final MealNameService mealNameService;
    private final OrdersService ordersService;
    private final MealService mealService;
    private final WeekDaysService weekDaysService;
    private final PlanService planService;
    private final PlansMealsService plansMealsService;


    public OrdersController(MealNameService mealNameService, OrdersService ordersService, MealService mealService, WeekDaysService weekDaysService, PlanService planService, PlansMealsService plansMealsService) {
        this.mealNameService = mealNameService;
        this.ordersService = ordersService;
        this.mealService = mealService;
        this.weekDaysService = weekDaysService;
        this.planService = planService;
        this.plansMealsService = plansMealsService;
    }

    @RequestMapping("/all")
    public String showAllOrders(Model model) {
        List<Orders> allOrders = ordersService.findAllOrders();
        model.addAttribute("orders", allOrders);
        return "orders/list";
    }

    @RequestMapping("/{id}")
    public String showOrder(@PathVariable("id") long id, Model model) {
        Optional<Orders> order = ordersService.getOrders(id);
        model.addAttribute("order", order);
        return "orders/getOrder";
    }

    @RequestMapping("/add")
    public String showFormToAddOrders(Model model) {
        model.addAttribute("order", new Orders());
        return "orders/add";
    }

    @PostMapping("/add")
    public String saveNewOrders(Orders orders) {
        ordersService.addOrders(orders);
        return "redirect:/orders/all";
    }

    @RequestMapping("/edit/{id}")
    public String edidOrderForm(@PathVariable("id") Long id, Model model) {
        Orders order = ordersService.getOrders(id).get();
        model.addAttribute("order", order);
        return "orders/edit";
    }

    @PostMapping("/edit")
    public String editOrder(Orders orders) {
        ordersService.editOrders(orders);
        return "redirect:/orders/all";
    }

    @RequestMapping("/delete/{id}")
    public String deleteOrder(@PathVariable("id") long id) {
        ordersService.deleteOrders(id);
        return "redirect:/orders/all";
    }


    //---------------Order Meal-----------------
    @GetMapping("/add/mealName")
    public String addMealNameGet(Model model, @SessionAttribute("shoppingCart") Orders orders) {
        printShoppingCart(orders);
        model.addAttribute("mealNames", mealNameService.findAll());
        model.addAttribute("mealName", new MealName());
        return "orders/addMealName";
    }

    @PostMapping("/add/mealName")
    public String addMealNamePost(MealName mealName) {
        return "redirect:/orders/add/mealName/meal/" + mealName.getId();
    }

    @GetMapping("/add/mealName/meal/{id}")
    public String addMealGet(@PathVariable Long id, Model model) {
        MealName mealName = mealNameService.findById(id);
        model.addAttribute("mealName", mealName);
        model.addAttribute("meals", mealService.findAllMealsByMealName(mealName));
        model.addAttribute("plansMeals", new PlansMeals());
        return "orders/addMealToPlansMeals";
    }

    @PostMapping("/add/mealName/meal")
    public String addMealPost(PlansMeals plansMeals, @RequestParam("quantity") Long quantity,
                              @SessionAttribute("shoppingCart") Orders shoppingCart,
                              Model model) {
        List<OrderMeals> shoppingItems = shoppingCart.getOrderMeals() == null ? new ArrayList<>() : shoppingCart.getOrderMeals();
        List<PlansMeals> plansMealsList = List.of(plansMeals);
        OrderMeals orderMeals = new OrderMeals();
        orderMeals.setPlansMeals(plansMealsList);
        orderMeals.setOrderType(OrderType.MEAL);
        shoppingItems.add(orderMeals);
        shoppingCart.setOrderMeals(shoppingItems);

        return "redirect:/home";
    }

    //---------Order Day from Plan--------
    @GetMapping("/add/selectPlan")
    public String addSelectPlanGet(Model model){
        model.addAttribute("plans", planService.findAll());
        model.addAttribute("plan", new Plan());
        return "orders/addSelectPlan";
    }


    @PostMapping("/add/selectPlan")
    public String addSelectPlanPost(Plan plan){
        return "redirect:/orders/add/selectPlan/selectDay/"+plan.getId();
    }

    @GetMapping("/add/selectPlan/selectDay/{id}")
    public String selectDayGet(@PathVariable Long id, Model model){
        Plan plan = planService.findById(id);
        model.addAttribute("weekDays", weekDaysService.findAll());
        model.addAttribute("plansMeals", new PlansMeals());
        model.addAttribute("plan", plan);

        return "/orders/orderPlanDay";
    }

    @PostMapping("/add/selectPlan/selectDay")
    public String selectDayGet(PlansMeals plansMeals, @SessionAttribute("shoppingCart") Orders shoppingCart){
        List<OrderMeals> shoppingItems = shoppingCart.getOrderMeals() == null ? new ArrayList<>() : shoppingCart.getOrderMeals();
        List<PlansMeals> planMealsList = plansMealsService.findAllByPlanAndWeekDays(plansMeals.getPlan(), plansMeals.getWeekDays());

        OrderMeals orderMeals = new OrderMeals();
        orderMeals.setPlansMeals(planMealsList);
        orderMeals.setOrderType(OrderType.PLANDAY);
        shoppingItems.add(orderMeals);

        shoppingCart.setOrderMeals(shoppingItems);

        return "redirect:/home";
    }

    //--------Order Plan---------------
    @GetMapping("/add/plan")
    public String addPlanGet(Model model){
        model.addAttribute("plans", planService.findAll());
        model.addAttribute("plansMeals", new PlansMeals());
        return "orders/addPlan";
    }


    @PostMapping("/add/plan")
    public String addPlanPost(PlansMeals plansMeals, @SessionAttribute("shoppingCart") Orders shoppingCart){
        List<OrderMeals> shoppingItems = shoppingCart.getOrderMeals()==null? new ArrayList<>(): shoppingCart.getOrderMeals();
        List<PlansMeals> plansMealsList = plansMealsService.findAllByPlan(plansMeals.getPlan());
        OrderMeals orderMeals = new OrderMeals();
        orderMeals.setPlansMeals(plansMealsList);
        orderMeals.setOrderType(OrderType.PLAN);
        shoppingItems.add(orderMeals);
        shoppingCart.setOrderMeals(shoppingItems);
        return "redirect:/home";
    }


    //PRINTING SHOPPING CART IN CONSOLE
    private void printShoppingCart(Orders orders) {
        if(orders.getOrderMeals()!=null) {
            System.out.println(orders.getOrderMeals().size());
            orders.getOrderMeals().forEach(
                    el -> {
                        System.out.println("OrderType: "+el.getOrderType()+"\n");
                        el.getPlansMeals().forEach(pm -> System.out.println(pm.getMeal().getName()));
                        System.out.println("----------------------");
                    }
            );
        }
    }
}
