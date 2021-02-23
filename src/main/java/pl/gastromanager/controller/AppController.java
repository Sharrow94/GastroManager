package pl.gastromanager.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.gastromanager.model.Meal;
import pl.gastromanager.model.Payments;
import pl.gastromanager.model.Users;
import pl.gastromanager.service.*;

import java.util.List;

@Controller
@RequestMapping("/app")
public class AppController {
    private final PaymentsService paymentsService;
    private final UserService userService;
    private final MealService mealService;
    private final DietService dietService;
    private final PlanService planService;


    public AppController(PaymentsService paymentsService, UserService userService, MealService mealService, DietService dietService, PlanService planService) {
        this.paymentsService = paymentsService;
        this.userService = userService;
        this.mealService = mealService;
        this.dietService = dietService;
        this.planService = planService;
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
        return "plan/showDetails";
    }
    //Method from OrdersController



}
