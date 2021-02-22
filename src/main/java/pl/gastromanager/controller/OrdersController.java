package pl.gastromanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gastromanager.model.MealName;
import pl.gastromanager.model.OrderMeals;
import pl.gastromanager.model.Orders;
import pl.gastromanager.model.PlansMeals;
import pl.gastromanager.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@SessionAttributes({"shoppingCart", "shoppingItem"})
@Controller
@RequestMapping("/orders")
public class OrdersController {
    private final MealNameService mealNameService;
    private final OrdersService ordersService;
    private final MealService mealService;
    private final WeekDaysService weekDaysService;
    private final PlanService planService;


    public OrdersController(MealNameService mealNameService, OrdersService ordersService, MealService mealService, WeekDaysService weekDaysService, PlanService planService) {
        this.mealNameService = mealNameService;
        this.ordersService = ordersService;
        this.mealService = mealService;
        this.weekDaysService = weekDaysService;
        this.planService = planService;
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


    //moje=============================

    //---------------MEALNAME-----------------
    @GetMapping("/add/mealName")
    public String addMealNameGet(Model model, @SessionAttribute("shoppingCart") Orders orders) {
        if(orders.getOrderMeals()!=null) {
            orders.getOrderMeals().forEach(
                    el -> {
                        el.getPlansMeals().forEach(pm -> System.out.println(pm.getMeal().getName()));
                        System.out.println("----------------------");
                    }
            );
            System.out.println(orders.getOrderMeals().size());
//            System.out.println(orders.getOrderPrice());
        }

        model.addAttribute("mealNames", mealNameService.findAll());
        model.addAttribute("mealName", new MealName());
        return "orders/addMealName";
    }

    @PostMapping("/add/mealName")
    public String addMealNamePost(MealName mealName) {
        return "redirect:/orders/add/mealName/meal/" + mealName.getId();
    }

    //---------------AddMeal---------------
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
        shoppingItems.add(orderMeals);
        shoppingCart.setOrderMeals(shoppingItems);

        return "redirect:/home";
    }

    //---------Zamów dzień z planu-------
    @GetMapping("/add/selectPlan")
    public String addDayPlanGet(Model model){
        model.addAttribute("plans", planService.findAll());
        return "orders/addSelectPlan";
    }

    @PostMapping("/add/selectPlan")
    public String addDayPlanPost(@RequestParam Long id){
        return "redirect:/orders/add/selectPlan/selectDay/"+id;
    }

//    @GetMapping("/add/selectPlan/selectDay/{id}")
//    public String selectDayGet(@PathVariable Long id){
//
//    }


}
