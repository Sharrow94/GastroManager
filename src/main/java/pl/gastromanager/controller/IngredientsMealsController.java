package pl.gastromanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gastromanager.model.Ingredient;
import pl.gastromanager.model.IngredientsMeals;
import pl.gastromanager.model.Meal;
import pl.gastromanager.service.DietService;
import pl.gastromanager.service.IngredientService;
import pl.gastromanager.service.IngredientsMealsService;
import pl.gastromanager.service.MealService;

import java.util.List;

@Controller
@RequestMapping("/meal/ingredient")
public class IngredientsMealsController {
    private final MealService mealService;
    private final DietService dietService;
    private final IngredientService ingredientService;
    private final IngredientsMealsService ingredientsMealsService;

    public IngredientsMealsController(MealService mealService, DietService dietService, IngredientService ingredientService, IngredientsMealsService ingredientsMealsService) {
        this.mealService = mealService;
        this.dietService = dietService;
        this.ingredientService = ingredientService;
        this.ingredientsMealsService = ingredientsMealsService;
    }

    @ModelAttribute("ingredients")
    List<Ingredient> ingredientsList(){
        return ingredientService.findAll();
    }


    @GetMapping("/add/{id}")
    public String addIngredientByIdGet(@PathVariable Long id, Model model){
        Meal meal = mealService.findMealById(id);
        IngredientsMeals ingredientsMeals = new IngredientsMeals();
        model.addAttribute("meal", meal);
        model.addAttribute("ingredientsMeals", ingredientsMeals);
        return "meal/addMealIngredient";
    }

    @PostMapping("/add")
    public String addIngredientPost(IngredientsMeals ingredientsMeals){
        ingredientsMeals.setPrice((float) (ingredientsMeals.getIngredient().getUnitPrice()*ingredientsMeals.getQuantity()));
        ingredientsMealsService.saveIngredientsMeals(ingredientsMeals);
        mealService.refreshMeal(ingredientsMeals.getMeal());
        return "redirect:/meal/details/"+ingredientsMeals.getMeal().getId();
    }

    @GetMapping("/edit/{id}")
    public String editIngredientByIdGet(@PathVariable Long id, Model model){
        IngredientsMeals im = ingredientsMealsService.findIngredientsMealsById(id);
        Meal meal = im.getMeal();
        model.addAttribute("ingredientsMeals", im);
        model.addAttribute("meal", meal);
        return "meal/editMealIngredient";
    }

    @PostMapping("/edit")
    public String editIngredientPost(IngredientsMeals ingredientsMeals){
        ingredientsMeals.setPrice((float) (ingredientsMeals.getIngredient().getUnitPrice()*ingredientsMeals.getQuantity()));
        ingredientsMealsService.saveIngredientsMeals(ingredientsMeals);
        mealService.refreshMeal(ingredientsMeals.getMeal());
        return "redirect:/meal/details/"+ingredientsMeals.getMeal().getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteIngredientGet(@PathVariable Long id){
        IngredientsMeals im = ingredientsMealsService.findIngredientsMealsById(id);
        Meal meal = im.getMeal();
        ingredientsMealsService.deleteIngredientsMeals(im);
        return "redirect:/meal/details/"+meal.getId();
    }
}
