package pl.gastromanager.model;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String userName;
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[\\!\\@\\#\\$\\%\\^\\&\\*\\(\\)\\_\\+\\-\\=])(?=.*[A-Z])(?!.*\\s).{8,}$")
    private String password;
    @Email
    private String email;
    @NotBlank
    @Pattern(regexp = "[A-Z][a-zA-Z]*")
    private String firstName;
    @NotBlank
    @Pattern(regexp = "[A-Z][a-zA-Z]*")
    private String lastName;
    private int enabled;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    private float salary;
    private String phoneNumber;
    private String city;
    private String street;
    private String nr;
    private String postNumber;
}
