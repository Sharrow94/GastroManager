package pl.gastromanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.gastromanager.model.Plan;
import pl.gastromanager.model.WeekDays;
import pl.gastromanager.service.PlanService;
import pl.gastromanager.service.WeekDaysService;

import java.util.List;

@Controller
@RequestMapping("/plan")
public class PlanController {

    private final PlanService planService;
    private final WeekDaysService weekDaysService;

    public PlanController(PlanService planService, WeekDaysService weekDaysService) {
        this.planService = planService;
        this.weekDaysService = weekDaysService;
    }

    @RequestMapping("/{id}")
    public String getIngredient(@PathVariable("id") Long id, Model model){
        model.addAttribute("plan",planService.findById(id).get());
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
        List<WeekDays>weekDays=weekDaysService.findAll();
        model.addAttribute("plan",plan);
        model.addAttribute("weekDays",weekDays);
        return "plan/addPlan";
    }

    @PostMapping("/add")
    public String ingredientAddForm(Plan plan){
        planService.addPlan(plan);
        return "redirect:/plan/all";
    }

    @RequestMapping("/edit/{id}")
    public String editIngredient(@PathVariable("id") Long id, Model model){
        Plan plan=planService.findById(id).get();
        List<WeekDays>weekDays=weekDaysService.findAll();
        model.addAttribute("plan",plan);
        model.addAttribute("weekDays",weekDays);
        return "plan/editPlan";
    }

    @PostMapping("/update")
    public String ingredientEditForm(Plan plan){
        planService.savePlan(plan);
        return "redirect:/plan/all";
    }
}

