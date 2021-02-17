package pl.gastromanager.service;

import pl.gastromanager.model.Ingredient;
import pl.gastromanager.model.Meal;

import java.util.HashMap;
import java.util.List;

public interface MealService {
    void saveMeal(Meal meal);
    void deleteMeal(Meal meal);
    Meal updateMeal(Meal meal);
    Meal findMealByName(String name);
    Meal findMealById(Long id);
    List<Meal> findAll();
    List<Ingredient> findAllMealIngredients(Meal meal);
    void addIngredient(Meal meal, Ingredient ingredient, float quantity);
    void addManyIngredients(Meal meal, HashMap<Ingredient, Float> ingredientsQuantity);
    void refreshMeal(Meal meal);
}
