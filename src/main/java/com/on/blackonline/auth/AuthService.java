package com.on.blackonline.auth;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.on.blackonline.auth.clients.ClientLoginRequest;
import com.on.blackonline.auth.clients.ClientRegisterRequest;
import com.on.blackonline.auth.employees.EmployeeLoginRequest;
import com.on.blackonline.auth.employees.EmployeeRegisterRequest;
import com.on.blackonline.jwt.JwtService;
import com.on.blackonline.persistences.entities.ClientEntity;
import com.on.blackonline.persistences.entities.EmployeeEntity;
import com.on.blackonline.persistences.repositories.ClientRepository;
import com.on.blackonline.persistences.repositories.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public AuthResponse loginClient(ClientLoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        UserDetails client = clientRepository.findByEmail(request.getEmail()).orElseThrow();
        String token = jwtService.getToken(client);

        Optional<ClientEntity> client1 = clientRepository.findByEmail(request.getEmail()); 
        Long id = client1.get().getClient_id();
        return AuthResponse.builder()
                .token(token)
                .id(id)
                .build();
    }

    public AuthResponse loginEmployee(EmployeeLoginRequest request) {
        try {   
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        UserDetails employee = employeeRepository.findByEmail(request.getEmail()).orElseThrow();
        String token = jwtService.getToken(employee);

        Optional<EmployeeEntity> employee1 = employeeRepository.findByEmail(request.getEmail()); 
        Long id = employee1.get().getEmployee_id();
        return AuthResponse.builder()
                .token(token)
                .id(id)
                .build();
    }

    public AuthResponse registerClient(ClientRegisterRequest request) {
        ClientEntity client = ClientEntity.builder()
                    .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .phone(request.getPhone())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .createdAt(LocalDateTime.now())
                    .build();

        clientRepository.save(client);

        Optional<ClientEntity> client1 = clientRepository.findByEmail(request.getEmail()); 
        Long id = client1.get().getClient_id();

        return AuthResponse
                .builder()
                .token(jwtService.getToken(client))
                .id(id)
                .build();
    }

    public AuthResponse registerEmployee(EmployeeRegisterRequest request) {
        EmployeeEntity employee = EmployeeEntity.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .gender(request.getGender())
                .phone(request.getPhone())
                .dateOfBirth(request.getDateOfBirth())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .address(request.getAddress())
                .role(request.getRole())
                .createdAt(LocalDateTime.now())
                .status(true)
                .build();

        employeeRepository.save(employee);

        Optional<EmployeeEntity> employee1 = employeeRepository.findByEmail(request.getEmail()); 
        Long id = employee1.get().getEmployee_id();

        return AuthResponse
                .builder()
                .token(jwtService.getToken(employee))
                .id(id)
                .build();
    }
}
