package pl.gastromanager.gastromanager.model;

import javax.persistence.*;

@Entity
public class Positions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private Manuals manuals;
}
