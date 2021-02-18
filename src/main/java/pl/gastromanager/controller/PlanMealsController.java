package pl.gastromanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.gastromanager.service.MealService;
import pl.gastromanager.service.PlanService;

@Controller
@RequestMapping("/plan/meals")
public class PlanMealsController {

    private final PlanService planService;
    private final MealService mealService;

    public PlanMealsController(PlanService planService, MealService mealService) {
        this.planService = planService;
        this.mealService = mealService;
    }

    @GetMapping("/list")
    public String addMealToPlan(){
        return null;
    }
}
