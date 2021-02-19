package pl.gastromanager.service;

import pl.gastromanager.model.Users;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<Users> getUsers();
    Users findByUserName(String userName);
    Users findByUserEmail(String email);
    void saveUser(Users users);
    void add(Users users);
    void update(Users users);
    void delete(Long id);
    Optional<Users> get(Long id);
}
