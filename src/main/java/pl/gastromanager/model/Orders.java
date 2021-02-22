package pl.gastromanager.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private String operationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String fromDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String toDate;
    private int quantity;
    private float orderPrice;
}
