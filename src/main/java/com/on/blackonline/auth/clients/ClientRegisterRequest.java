package com.on.blackonline.auth.clients;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientRegisterRequest {
    String firstName;
    String lastName;
    String phone;
    String email;
    String password;    
}
