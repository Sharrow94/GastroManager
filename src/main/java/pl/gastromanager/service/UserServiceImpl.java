package pl.gastromanager.service;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.gastromanager.model.AuthProvider;
import pl.gastromanager.model.Role;
import pl.gastromanager.model.Users;
import pl.gastromanager.repository.RoleRepository;
import pl.gastromanager.repository.UserRepository;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users findByUserName(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public Users findByUserEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(Users users) {
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        users.setEnabled(1);
        users.setAuthProvider(AuthProvider.LOCAL);
        Role userRole = roleRepository.findByName("ROLE_USER");
        users.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(users);
    }

    @Override
    public void add(Users users) {
        userRepository.save(users);

    }

    @Override
    public void update(Users users) {
        userRepository.save(users);

    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public Users get(Long id) {
        return userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("User does not exists"));
    }

    @Override
    public void saveUserAfterOAuth2(String email, String name, AuthProvider provider) {
        Users user = new Users();
        String[] s = name.split(" ");
        user.setEmail(email);
        user.setFirstName(s[0]);
        user.setLastName(s[1]);
        user.setUserName(email);
        user.setEnabled(1);
        user.setAuthProvider(provider);
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));

        userRepository.save(user);
    }

    @Override
    public void updateUserAfterOAuth2(Users user, String name, AuthProvider provider) {
        String[] s = name.split(" ");
        user.setAuthProvider(provider);
        user.setFirstName(s[0]);
        user.setLastName(s[1]);

        userRepository.save(user);
    }
}
