package pl.gastromanager.service;

import pl.gastromanager.model.Meal;

import java.util.List;

public interface MealService {
    void saveMeal(Meal meal);
    void deleteMeal(Meal meal);
    Meal updateMeal(Meal meal);
    Meal findMealByName(String name);
    Meal findMealById(Long id);
    List<Meal> findAll();
}
