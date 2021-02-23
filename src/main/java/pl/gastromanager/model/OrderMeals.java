package pl.gastromanager.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class OrderMeals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private Orders order;
    @ManyToMany
    @JoinTable(name = "plan_order")
    private List<PlansMeals> plansMeals;
    private Long quantity;
    private float price;
    @Enumerated(EnumType.STRING)
    private OrderType orderType;
}