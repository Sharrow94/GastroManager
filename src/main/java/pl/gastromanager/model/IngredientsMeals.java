package pl.gastromanager.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class IngredientsMeals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Meal meal;
    @ManyToOne
    private Ingredient ingredient;
    private double quantity;
    private float price;
}
