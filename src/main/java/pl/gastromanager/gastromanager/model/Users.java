package pl.gastromanager.gastromanager.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private boolean isSuperAdmin;
    @ManyToOne
    private OrganizationalUnit organizationalUnit;
//    @OneToMany
//    private List<Orders> orders;
}
