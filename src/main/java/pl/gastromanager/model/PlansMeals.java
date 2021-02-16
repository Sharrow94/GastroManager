package pl.gastromanager.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class PlansMeals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @OneToMany
//    private List<Plan> plans;
//    @OneToMany
//    private List<Meal> meals;
    @ManyToOne
    private Plan plan;
    @ManyToOne
    private Meal meal;

    @ManyToOne
    private MealName mealName;
}
