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
    private float foodCostTotal;
    private float price;
    @OneToMany(mappedBy = "plan", cascade = CascadeType.REMOVE)
    private List<PlansMeals> plansMeals;
    @ManyToOne
    private Diet diet;
    private boolean hasGluten;
    private boolean hasMeat;
    private boolean hasLactose;
}
