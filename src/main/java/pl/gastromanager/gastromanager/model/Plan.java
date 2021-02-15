package pl.gastromanager.gastromanager.model;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.List;

@Entity
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany
    private List<Meal> meals;
    @ManyToOne
    private WeekDays weekDays;
    @OneToMany(mappedBy = "plan")
    List<Orders> orders;
    private float price;
}
