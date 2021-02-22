package pl.gastromanager.model;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
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
    private String firstName;
    @NotBlank
    private String lastName;
    private int enabled;
    private float salary;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role")
    private Set<Role> roles;
    private String phoneNumber;
    private String city;
    private String street;
    private String nr;
    private String postNumber;
    @Enumerated(EnumType.STRING)
    private AuthProvider authProvider;
}
