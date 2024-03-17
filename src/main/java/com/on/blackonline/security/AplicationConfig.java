package com.on.blackonline.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.on.blackonline.persistences.repositories.ClientRepository;
import com.on.blackonline.persistences.repositories.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor

public class AplicationConfig {

    private final ClientRepository clientRepository;
    private final EmployeeRepository employeeRepository;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(clientDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService clientDetailsService() {
        return client -> clientRepository.findByEmail(client)
        .orElseThrow(() -> new UsernameNotFoundException("Client not found"));
    }

    @Bean
    public UserDetailsService employeeDetailsService(){
        return employee -> employeeRepository.findByEmail(employee)
        .orElseThrow(() -> new UsernameNotFoundException("Employee not found"));
    }

    // @Bean
    // public AuthenticationProvider employeeAuthenticationProvider() {
    //     DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    //     provider.setUserDetailsService(employeeDetailsService());
    //     provider.setPasswordEncoder(passwordEncoder());
    //     return provider;
    // }
}
