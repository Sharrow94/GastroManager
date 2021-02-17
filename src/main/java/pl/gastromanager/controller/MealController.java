package pl.gastromanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gastromanager.model.Meal;
import pl.gastromanager.service.DietService;
import pl.gastromanager.service.IngredientService;
import pl.gastromanager.service.IngredientsMealsService;
import pl.gastromanager.service.MealService;

@RequestMapping("/meal")
@Controller
public class MealController {
    private final MealService mealService;
    private final DietService dietService;

    public MealController(MealService mealService, DietService dietService) {
        this.mealService = mealService;
        this.dietService = dietService;
    }

    @GetMapping("/list")
    public String listMeal(Model model){
        model.addAttribute("meals", mealService.findAll());
        return "meal/showAllMeals";
    }

    @GetMapping("/add")
    public String addMealGet(Model model){
        model.addAttribute("meal", new Meal());
        return "meal/addMeal";
    }

    @PostMapping("/add")
    public String addMealPost(Meal meal){
        meal.setDiet(dietService.findDietByName("Normalna"));
        mealService.saveMeal(meal);
        return "redirect:/meal/list";
    }

    @GetMapping("/details/{id}")
    public String showMealDetails(@PathVariable Long id, Model model){
        Meal meal = mealService.findMealById(id);
        model.addAttribute("meal", meal);
        return "meal/showDetails";
    }

    @GetMapping("/edit/{id}")
    public String editMealGet(@PathVariable Long id, Model model){
        model.addAttribute("meal", mealService.findMealById(id));
        return "/meal/editMeal";
    }

    @PostMapping("/edit")
    public String editMealPost(Meal meal, Model model){
        mealService.updateMeal(meal);
        model.addAttribute("meal", meal);
        return "redirect:/meal/list";
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
}
