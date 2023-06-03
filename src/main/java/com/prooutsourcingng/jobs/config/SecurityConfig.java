package com.prooutsourcingng.jobs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/api/jobs/2/applications").permitAll()
                        .anyRequest().authenticated()
        ).formLogin((form) -> form
                        .loginPage("/")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll());

//        httpSecurity.csrf().disable()
//                .authorizeHttpRequests((authorize) -> authorize.requestMatchers(HttpMethod.GET, "/api/**").authenticated())
//                .httpBasic(Customizer.withDefaults());

        return  httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}
