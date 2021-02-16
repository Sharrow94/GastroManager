package pl.gastromanager.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private WeekDays weekDays;
    @OneToMany(mappedBy = "plan")
    List<Orders> orders;
    private float price;
    @OneToMany(mappedBy = "plan")
    private List<PlansMeals> plansMeals;
}
