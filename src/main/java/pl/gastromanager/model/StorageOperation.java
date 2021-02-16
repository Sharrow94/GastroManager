package pl.gastromanager.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class StorageOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float unitPrice;
    private float quantity;
    private String operationType;
    private String invoiceNumber;
    private LocalDateTime date;
    @OneToOne
    private Ingredient ingredient;
    @OneToOne
    private Supplier supplier;
}
