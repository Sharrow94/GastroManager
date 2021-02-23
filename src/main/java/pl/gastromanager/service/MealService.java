package pl.gastromanager.service;

import pl.gastromanager.model.Ingredient;
import pl.gastromanager.model.Meal;
import pl.gastromanager.model.MealName;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface MealService {
    void saveMeal(Meal meal);
    void deleteMeal(Meal meal);
    Meal updateMeal(Meal meal);
    Meal findMealByName(String name);
    Meal findMealById(Long id);
    List<Meal> findAll();
    List<Ingredient> findAllMealIngredients(Meal meal);
    void refreshMeal(Meal meal);
    Set<Meal> findAllMealsByMealName(MealName mealName);
}
