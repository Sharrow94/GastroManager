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

//    @ModelAttribute("diets")
//    List<Diet> diets(){
//        return dietService.findAllDiets();
//    }

    @ModelAttribute("ingredients")
    List<Ingredient> ingredientsList(){
        return ingredientService.findAll();
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

//    @GetMapping("/ingredient/add")
//    public String addIngredientGet(@RequestParam String name, Model model) {
//        Meal meal = mealService.findMealByName(name.replace("_", " "));
//        IngredientsMeals ingredientsMeals = new IngredientsMeals();
//        ingredientsMeals.setMeal(meal);
//        model.addAttribute("ingredientsMeals", ingredientsMeals);
//        return "meal/addMealIngredient";
//    }

    @GetMapping("/ingredient/add/{id}")
    public String addIngredientByIdGet(@PathVariable Long id, Model model){
        Meal meal = mealService.findMealById(id);
        IngredientsMeals ingredientsMeals = new IngredientsMeals();
//        ingredientsMeals.setMeal(meal);
        model.addAttribute("meal", meal);
        model.addAttribute("ingredientsMeals", ingredientsMeals);
        return "meal/addMealIngredient";
    }

    @PostMapping("/ingredient/add")
    @ResponseBody
    public String addIngredientPost(IngredientsMeals ingredientsMeals){
        ingredientsMeals.setPrice((float) (ingredientsMeals.getIngredient().getUnitPrice()*ingredientsMeals.getQuantity()));
        ingredientsMealsService.saveIngredientsMeals(ingredientsMeals);
        mealService.refreshMeal(ingredientsMeals.getMeal());
        return "added";
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
