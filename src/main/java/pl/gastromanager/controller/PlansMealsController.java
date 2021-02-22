package pl.gastromanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gastromanager.model.*;
import pl.gastromanager.service.*;

import java.util.List;

@Controller
@RequestMapping("/plan/meal")
public class PlansMealsController {
    private final PlansMealsService plansMealsService;
    private final WeekDaysService weekDaysService;
    private final MealNameService mealNameService;
    private final MealService mealService;
    private final PlanService planService;

    public PlansMealsController(PlansMealsService plansMealsService, WeekDaysService weekDaysService, MealNameService mealNameService, MealService mealService, PlanService planService) {
        this.plansMealsService = plansMealsService;
        this.weekDaysService = weekDaysService;
        this.mealNameService = mealNameService;
        this.mealService = mealService;
        this.planService = planService;
    }

    @ModelAttribute("mealNames")
    List<MealName> mealNames(){
        return mealNameService.findAll();
    }

    @GetMapping("/add/{id}")
    public String addMealGet(@PathVariable Long id , Model model){
        model.addAttribute("plan", planService.findById(id));
        model.addAttribute("plansMeals", new PlansMeals());
        model.addAttribute("meals", mealService.findAll());
        model.addAttribute("weekDays", weekDaysService.findAll());
        return "plan/addPlanMeal";
    }

    @PostMapping("/add")
    public String addMealPost(PlansMeals plansMeals){
        plansMealsService.savePlansMeals(plansMeals);
        planService.refreshPlan(plansMeals.getPlan());
        return "redirect:/plan/"+plansMeals.getPlan().getId();
    }

    @GetMapping("/edit/{id}")
    public String editMealGet(@PathVariable Long id , Model model){
        PlansMeals pm = plansMealsService.findPlansMealsById(id);
        Plan plan = pm.getPlan();
        model.addAttribute("plan", plan);
        model.addAttribute("plansMeals", pm);
        model.addAttribute("meals", mealService.findAll());
        model.addAttribute("weekDays", weekDaysService.findAll());
        return "plan/editPlanMeal";
    }

    @PostMapping("/edit")
    public String editMealPost(PlansMeals plansMeals){
        plansMealsService.editPlansMeals(plansMeals);
        planService.refreshPlan(plansMeals.getPlan());
        return "redirect:/plan/"+plansMeals.getPlan().getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteMealGet(@PathVariable Long id){
        PlansMeals pm = plansMealsService.findPlansMealsById(id);
        Plan plan = pm.getPlan();
        plansMealsService.deletePlansMeals(pm);
        planService.refreshPlan(plan);
        return "redirect:/plan/"+plan.getId();
    }

}
