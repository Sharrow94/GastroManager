package pl.gastromanager.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
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
    @ManyToMany
    @JoinTable(name = "user_role")
    private List<Role> role;
    private float salary;
    private String phoneNumber;
    private String city;
    private String street;
    private String nr;
    private String postNumber;
}
