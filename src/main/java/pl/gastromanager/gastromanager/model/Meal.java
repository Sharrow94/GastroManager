package pl.gastromanager.gastromanager.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "meal")
    private List<IngredientsMeals> ingredientsMeals;
    @ManyToOne
    private Diet diet;
    private float price;
}
