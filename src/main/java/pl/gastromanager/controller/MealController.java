package pl.gastromanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gastromanager.model.Diet;
import pl.gastromanager.model.Meal;
import pl.gastromanager.service.DietService;
import pl.gastromanager.service.MealService;

import java.util.List;

@RequestMapping("/meal")
@Controller
public class MealController {
    private final MealService mealService;
    private final DietService dietService;

    public MealController(MealService mealService, DietService dietService) {
        this.mealService = mealService;
        this.dietService = dietService;
    }

    @ModelAttribute("diets")
    List<Diet> diets(){
        return dietService.findAllDiets();
    }

    @GetMapping("/add")
    public String addMealGet(Model model){
        model.addAttribute("meal", new Meal());
        return "/meal/addMeal";
    }

    @PostMapping("/add")
    @ResponseBody
    public String addMealPost(Meal meal){
        meal.setHasGluten(meal.getDiet().isHasGluten());
        meal.setHasLactose(meal.getDiet().isHasLactose());
        meal.setHasMeat(meal.getDiet().isHasMeat());
        mealService.saveMeal(meal);
        return meal.getName()+" "+meal.getDescription();
    }

    @GetMapping("/edit/{id}")
    public String editMealGet(@PathVariable Long id, Model model){
        model.addAttribute("meal", mealService.findMealById(id));
        return "/meal/editMeal";
    }

    @PostMapping("/edit")
    @ResponseBody
    public String editMealPost(Meal meal, Model model){
        mealService.updateMeal(meal);
        model.addAttribute("meal", meal);
        return "Meal has been edited";
    }

    @GetMapping("/delete/{id}")
    public String deleteMeal(@PathVariable Long id){
        Meal meal = mealService.findMealById(id);
        mealService.deleteMeal(meal);
        return "redirect:/meal/list";
    }

    @GetMapping("/delete/confirm/{id}")
    public String confirmDelete(@PathVariable int id, Model model){
        model.addAttribute("id", id);
        return "meal/deleteConfirm";
    }

    @GetMapping("/list")
    public String listMeal(Model model){
        model.addAttribute("meals", mealService.findAll());
        return "meal/showAllMeals";
    }

}
