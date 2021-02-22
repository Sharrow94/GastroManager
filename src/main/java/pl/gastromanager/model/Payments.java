package pl.gastromanager.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@Entity
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float cost;
    @ManyToOne
    private Users users;
    @OneToOne
    private Orders orders;
    private boolean isPayed;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private String date;
}
