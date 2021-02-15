package pl.gastromanager.gastromanager.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class IngredientsMeals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Meal meal;
    @ManyToOne
    private Ingredient ingredient;
    private double ingredientQuantity;
    private float price;
}
