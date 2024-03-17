package com.on.blackonline.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.on.blackonline.auth.clients.ClientLoginRequest;
import com.on.blackonline.auth.clients.ClientRegisterRequest;
import com.on.blackonline.auth.employees.EmployeeLoginRequest;
import com.on.blackonline.auth.employees.EmployeeRegisterRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    
    @PostMapping("/login/client")
    public ResponseEntity<AuthResponse> loginClient(@RequestBody ClientLoginRequest request) {
        return ResponseEntity.ok(authService.loginClient(request));
    }

    @PostMapping("/login/employee")
    public ResponseEntity<AuthResponse> loginEmployee(@RequestBody EmployeeLoginRequest request) {
        return ResponseEntity.ok(authService.loginEmployee(request));
    }

    @PostMapping("/register/client")
    public ResponseEntity<AuthResponse> registerClient(@RequestBody ClientRegisterRequest request) {
        return ResponseEntity.ok(authService.registerClient(request));
    }

    @PostMapping("/register/employee")
    public ResponseEntity<AuthResponse> registerEmployee(@RequestBody EmployeeRegisterRequest request) {
        return ResponseEntity.ok(authService.registerEmployee(request));
    }
}