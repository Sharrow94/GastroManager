package pl.gastromanager.gastromanager.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class CurrentStorage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Ingredient ingredient;
    private float unitPrice;
    private float quantity;
    @OneToOne
    private Supplier supplier;
}
