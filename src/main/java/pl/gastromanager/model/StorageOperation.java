package pl.gastromanager.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class StorageOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float unitPrice;
    private float quantity;
    @ManyToOne
    private Ingredient ingredient;
    @ManyToOne
    private StorageOperationItem storageOperationItem;
}
