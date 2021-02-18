package pl.gastromanager.service;

import pl.gastromanager.model.IngredientsMeals;

public interface IngredientsMealsService {
    void saveIngredientsMeals(IngredientsMeals ingredientsMeals);
    IngredientsMeals findIngredientsMealsById(Long id);
    void deleteIngredientsMeals(IngredientsMeals ingredientsMeals);
}
