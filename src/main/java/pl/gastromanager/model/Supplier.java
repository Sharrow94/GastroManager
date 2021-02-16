package pl.gastromanager.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nip;
    private String phoneNumber;
    private String city;
    private String street;
    private String nr;
    private String postNumber;
}
