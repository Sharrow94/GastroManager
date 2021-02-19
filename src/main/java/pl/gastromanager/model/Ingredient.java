package pl.gastromanager.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int calories;
    private float unitPrice;
    private boolean hasGluten;
    private boolean hasMeat;
    private boolean hasLactose;
    private float currentQuantity;
    private String unit;
}
