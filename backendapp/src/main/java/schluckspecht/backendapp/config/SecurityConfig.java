package schluckspecht.backendapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers(new AntPathRequestMatcher("/Contactforms")).permitAll();
                    auth.requestMatchers(new AntPathRequestMatcher("/Timelineposts")).permitAll();
                    auth.requestMatchers(new AntPathRequestMatcher("/Feedposts ")).permitAll();
                    auth.requestMatchers(new AntPathRequestMatcher("/login ")).permitAll();
                    auth.anyRequest().authenticated();
                })
                .formLogin(form -> form
                        .loginProcessingUrl("/login")
                        .loginPage("/login")
                        .permitAll()
                )
                .build();
    }
}
