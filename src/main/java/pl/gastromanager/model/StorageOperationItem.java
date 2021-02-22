package pl.gastromanager.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class StorageOperationItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String documentNumber;
    @ManyToOne
    Supplier supplier;
    private float price;
    private LocalDate date;
    private String operationType;
}
