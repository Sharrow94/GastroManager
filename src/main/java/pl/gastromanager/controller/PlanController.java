package pl.gastromanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.gastromanager.model.Plan;
import pl.gastromanager.service.DietService;
import pl.gastromanager.service.PlanService;

@Controller
@RequestMapping("/plan")
public class PlanController {

    private final PlanService planService;
    private final DietService dietService;

    public PlanController(PlanService planService, DietService dietService) {
        this.planService = planService;
        this.dietService = dietService;
    }

    @RequestMapping("/{id}")
    public String getIngredient(@PathVariable("id") Long id, Model model){
        model.addAttribute("plan",planService.findById(id));
        return "plan/showDetails";
    }

    @RequestMapping("/all")
    public String getAllIngredients(Model model){
        model.addAttribute("plans",planService.findAll());
        return "plan/all";
    }

    @RequestMapping("/delete/{id}")
    public String deleteIngredient(@PathVariable("id")Long id){
        planService.deletePlan(id);
        return "redirect:/plan/all";
    }

    @RequestMapping("/add")
    public String addIngredient(Model model){
        Plan plan=new Plan();
        model.addAttribute("plan",plan);
        return "plan/addPlan";
    }

    @PostMapping("/add")
    public String ingredientAddForm(Plan plan){
        plan.setDiet(dietService.findDietByName("Normalna"));
        planService.addPlan(plan);
        return "redirect:/plan/all";
    }

    @RequestMapping("/edit/{id}")
    public String editIngredient(@PathVariable("id") Long id, Model model){
        Plan plan=planService.findById(id);
        model.addAttribute("plan",plan);
        return "plan/editPlan";
    }

    @PostMapping("/update")
    public String ingredientEditForm(Plan plan){
        planService.savePlan(plan);
        return "redirect:/plan/all";
    }
}

