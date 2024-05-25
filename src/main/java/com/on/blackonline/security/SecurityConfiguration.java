package com.on.blackonline.security;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.on.blackonline.jwt.JwtAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;
  
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authRequest ->
                    authRequest
                        .requestMatchers(AUTH_WHITELIST).permitAll() // <- Aqui se configura la ruta que se permiten
                        .anyRequest().authenticated() // <- Aqui se configura la ruta que se protegen
                    )
                .sessionManagement(sessionManagement -> 
                            sessionManagement
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    private static final String[] AUTH_WHITELIST = {
        "/auth/**",
        "/doc/swagger-ui.html",
        "/doc/swagger-ui/**",
        "/v3/api-docs/**",
        "/v3/api-docs.yml",
        "/email",
        "/validate-code",
        "/jwt/validate-token",
        "/api/**"
    };
}
