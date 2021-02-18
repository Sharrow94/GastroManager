package pl.gastromanager.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private String date;
}
