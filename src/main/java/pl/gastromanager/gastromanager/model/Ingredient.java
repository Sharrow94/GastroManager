package pl.gastromanager.gastromanager.model;

import jdk.dynalink.linker.LinkerServices;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int calories;
    private float unitPrice;
    private boolean hasGluten;
    private boolean hasMeat;
    private boolean hasLactose;
//    @OneToMany(mappedBy = "ingredient")
//    private List<IngredientsMeals> ingredientsMeals;
}
