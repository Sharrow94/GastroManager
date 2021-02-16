package pl.gastromanager.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime operationDate;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
    private float orderPrice;
    @ManyToOne
    private Plan plan;

}
