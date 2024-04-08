package com.on.blackonline.mail;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.on.blackonline.auth.AuthResponse;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @SuppressWarnings("rawtypes")
    @PostMapping("/email")
    public ResponseEntity validateEmail(@RequestBody EmailEntity request) throws MessagingException {
        return emailService.validateEmail(request);
    }

    // Esta mae ya jala si el codigo es correcto, te devuelve un token
    // Si hay un error con el codigo, hayar la manera de retornar un error
    @PostMapping("/validate-code")
    public ResponseEntity<AuthResponse> validateCode(@RequestBody EmailEntity request) {
        return ResponseEntity.ok(emailService.validateCode(request));
    }

    @SuppressWarnings("rawtypes")
    @PostMapping("/change-password")
    public ResponseEntity changePassword(@RequestBody ChangePasswordEntity request) {
        return ResponseEntity.ok(emailService.changePassword(request));
    }
}
