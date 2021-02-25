package pl.gastromanager.service;

import pl.gastromanager.model.AuthProvider;
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
    Users get(Long id);
    void saveUserAfterOAuth2(String email, String name, AuthProvider provider);
    void updateUserAfterOAuth2(Users user, String name, AuthProvider provider);
}
