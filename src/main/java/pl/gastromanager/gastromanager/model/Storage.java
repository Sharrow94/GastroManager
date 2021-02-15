package pl.gastromanager.gastromanager.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Ingredient ingredient;
    private Long totalQuantity;
    private String unit;
}
