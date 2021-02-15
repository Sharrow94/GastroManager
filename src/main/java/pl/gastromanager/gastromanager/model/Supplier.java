package pl.gastromanager.gastromanager.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    private List<Ingredient> ingredients;
}
