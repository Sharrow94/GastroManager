package pl.gastromanager.util;

import pl.gastromanager.model.Ingredient;
import pl.gastromanager.model.IngredientsMeals;
import pl.gastromanager.model.Meal;


public class IngredientsMealsBuilder {
    private Meal meal;
    private Ingredient ingredient;
    private double quantity;
    private float price;

    public IngredientsMealsBuilder meal(Meal meal) {
        this.meal = meal;
        return this;
    }

    public IngredientsMealsBuilder ingredient(Ingredient ingredient) {
        this.ingredient = ingredient;
        return this;
    }

    public IngredientsMealsBuilder quantity(double quantity) {
        this.quantity = quantity;
        return this;
    }

    public IngredientsMeals build(){
        IngredientsMeals ingredientsMeals = new IngredientsMeals();
//        ingredientsMeals.setMeal(this.meal);
        ingredientsMeals.setIngredient(this.ingredient);
        ingredientsMeals.setQuantity(this.quantity);
        ingredientsMeals.setPrice((float) (ingredient.getUnitPrice()*this.quantity));
        return ingredientsMeals;
    }
}
