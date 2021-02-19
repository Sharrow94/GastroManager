package pl.gastromanager.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @NumberFormat
    private float cost;
    @NotBlank
    @ManyToOne
    private Users users;
    @NotBlank
    @OneToOne
    private Orders orders;
    private boolean isPayed;
    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private String  date;
}
