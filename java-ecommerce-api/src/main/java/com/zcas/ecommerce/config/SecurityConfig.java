package com.zcas.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF for testing endpoints via curl
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/products/**").permitAll() // Publicly browse products
                .requestMatchers("/h2-console/**").permitAll()   // Public access to database panel
                .anyRequest().authenticated()                    // Lock down cart and checkout
            )
            .headers(headers -> headers.frameOptions(frame -> frame.disable())) // Required for H2 UI console
            .httpBasic(withDefaults()); // Enable standard HTTP Basic login popup prompt

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Create a default test user credential set for your portfolio
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("zcas_developer")
                .password("rakuten2028")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}
