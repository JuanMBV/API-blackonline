package com.on.blackonline.jwt;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/jwt")
@RequiredArgsConstructor
public class JwtController {

    private final JwtService jwtService;

    @PostMapping("/validate-token")
    public boolean validateToken(@RequestBody JwtEntity request) {
        return jwtService.isTokenExpired(request.getToken());
    }
    
}
