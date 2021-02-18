package pl.gastromanager.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.gastromanager.model.Role;
import pl.gastromanager.model.Users;
import pl.gastromanager.repository.RoleRepository;
import pl.gastromanager.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

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
    public void saveUser(Users users) {
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        users.setEnabled(1);
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
    public Optional<Users> get(Long id) {
        return userRepository.findById(id);
    }
}
