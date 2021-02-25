package pl.gastromanager.oauth2;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import pl.gastromanager.model.AuthProvider;
import pl.gastromanager.model.Users;
import pl.gastromanager.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class OAuth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Autowired
    private UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        CustomOAuth2User oAuth2User = (CustomOAuth2User) authentication.getPrincipal();
        String email = oAuth2User.getName();
        String name = oAuth2User.getUserName();
//        System.out.println(email);
        Users user = userService.findByUserEmail(email);

        if(user==null){
            //register new user
            userService.saveUserAfterOAuth2(email, name, AuthProvider.GOOGLE);
        }else {
            //update existing user
        }



        super.onAuthenticationSuccess(request, response, authentication);
    }
}
