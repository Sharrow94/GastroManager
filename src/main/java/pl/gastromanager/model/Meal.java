package pl.gastromanager.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "meal", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<IngredientsMeals> ingredientsMeals;
    @ManyToOne
    private Diet diet;
    private String description;
    private float price;
    private boolean hasGluten;
    private boolean hasMeat;
    private boolean hasLactose;
}
