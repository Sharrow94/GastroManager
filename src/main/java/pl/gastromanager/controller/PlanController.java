package pl.gastromanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.gastromanager.model.Plan;
import pl.gastromanager.service.DietService;
import pl.gastromanager.service.OrdersService;
import pl.gastromanager.service.PlanService;

@Controller
@RequestMapping("/admin/plan")
public class PlanController {

    private final PlanService planService;
    private final DietService dietService;
    private final OrdersService ordersService;

    public PlanController(PlanService planService, DietService dietService, OrdersService ordersService) {
        this.planService = planService;
        this.dietService = dietService;
        this.ordersService = ordersService;
    }


    @RequestMapping("/add")
    public String addPlan(Model model) {
        Plan plan = new Plan();
        model.addAttribute("plan", plan);
        return "plan/addPlan";
    }

    @PostMapping("/add")
    public String planAddForm(Plan plan) {
        plan.setDiet(dietService.findDietByName("Normalna"));
        planService.addPlan(plan);
        return "redirect:/app/plan/all";
    }

    @RequestMapping("/edit/{id}")
    public String editPlan(@PathVariable("id") Long id, Model model) {
        Plan plan = planService.findById(id).get();
        model.addAttribute("plan", plan);
        return "plan/editPlan";
    }

    @PostMapping("/update")
    public String planEditForm(Plan plan) {
        planService.savePlan(plan);
        return "redirect:/app/plan/all";
    }

    @RequestMapping("/delete/{id}")
    public String deletePlan(@PathVariable("id") Long id) {
        planService.deletePlan(id);
        return "redirect:/app/plan/all";
    }
}

