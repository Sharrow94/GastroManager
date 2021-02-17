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

@RequestMapping("/meal")
@Controller
public class MealController {
    private final MealService mealService;
    private final DietService dietService;
    private final IngredientService ingredientService;
    private final IngredientsMealsService ingredientsMealsService;

    public MealController(MealService mealService, DietService dietService, IngredientService ingredientService, IngredientsMealsService ingredientsMealsService) {
        this.mealService = mealService;
        this.dietService = dietService;
        this.ingredientService = ingredientService;
        this.ingredientsMealsService = ingredientsMealsService;
    }

    @ModelAttribute("ingredients")
    List<Ingredient> ingredientsList(){
        return ingredientService.findAll();
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

    @GetMapping("/ingredient/add/{id}")
    public String addIngredientByIdGet(@PathVariable Long id, Model model){
        Meal meal = mealService.findMealById(id);
        IngredientsMeals ingredientsMeals = new IngredientsMeals();
        model.addAttribute("meal", meal);
        model.addAttribute("ingredientsMeals", ingredientsMeals);
        return "meal/addMealIngredient";
    }

    @PostMapping("/ingredient/add")
    public String addIngredientPost(IngredientsMeals ingredientsMeals){
        ingredientsMeals.setPrice((float) (ingredientsMeals.getIngredient().getUnitPrice()*ingredientsMeals.getQuantity()));
        ingredientsMealsService.saveIngredientsMeals(ingredientsMeals);
        mealService.refreshMeal(ingredientsMeals.getMeal());
        return "redirect:/meal/details/"+ingredientsMeals.getMeal().getId();
    }

    @GetMapping("/ingredient/edit/{id}")
    public String editIngredientByIdGet(@PathVariable Long id, Model model){
        IngredientsMeals im = ingredientsMealsService.findIngredientsMealsById(id);
        Meal meal = im.getMeal();
        model.addAttribute("ingredientsMeals", im);
        model.addAttribute("meal", meal);
        return "meal/editMealIngredient";
    }

    @PostMapping("/ingredient/edit")
    public String editIngredientPost(IngredientsMeals ingredientsMeals){
        ingredientsMeals.setPrice((float) (ingredientsMeals.getIngredient().getUnitPrice()*ingredientsMeals.getQuantity()));
        ingredientsMealsService.saveIngredientsMeals(ingredientsMeals);
        mealService.refreshMeal(ingredientsMeals.getMeal());
        return "redirect:/meal/details/"+ingredientsMeals.getMeal().getId();
    }

    @GetMapping("/ingredient/delete/{id}")
    public String deleteIngredientGet(@PathVariable Long id){
        IngredientsMeals im = ingredientsMealsService.findIngredientsMealsById(id);
        Meal meal = im.getMeal();
        ingredientsMealsService.deleteIngredientsMeals(im);
        return "redirect:/meal/details/"+meal.getId();
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
}
