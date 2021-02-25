package pl.gastromanager.security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import pl.gastromanager.model.Users;
import pl.gastromanager.service.UserService;

@Component
public class UserSecurity {
    private final UserService userService;

    public UserSecurity(UserService userService) {
        this.userService = userService;
    }

    public boolean isCurrentUser(Authentication authentication, Long id){
        Users users = userService.get(id);
        return authentication.getName().equals(users.getEmail());
    }
}
