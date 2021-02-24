package pl.gastromanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.gastromanager.oauth2.CustomOAuth2UserService;
import pl.gastromanager.oauth2.OAuth2LoginSuccessHandler;

import javax.persistence.Access;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public SpringDataUserDetailsService customUserDetailsService() {
        return new SpringDataUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //TODO: Dodać odpowiednie prefiksy
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/oauth2/**").permitAll()
                .antMatchers("/home/**").authenticated()
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/app/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .defaultSuccessUrl("/home")
                .and()
                .oauth2Login()
                    .loginPage("/login")
                    .userInfoEndpoint().userService(oAuth2UserService)
                    .and()
                    .successHandler(oAuth2LoginSuccessHandler)
//                    .defaultSuccessUrl("/home")
                .and().logout().logoutSuccessUrl("/login")
                .permitAll();
    }

    @Autowired
    private CustomOAuth2UserService oAuth2UserService;

    @Autowired
    private OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler;
}
