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
    @ManyToOne
    private Plan plan;
    @ManyToOne
    private Meal meal;
    @ManyToOne
    private WeekDays weekDays;
    @ManyToOne
    private MealName mealName;
}
