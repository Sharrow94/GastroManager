package pl.gastromanager.gastromanager.model;

import javax.persistence.*;

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
}
