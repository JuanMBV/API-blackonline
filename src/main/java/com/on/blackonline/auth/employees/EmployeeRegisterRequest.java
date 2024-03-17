package com.on.blackonline.auth.employees;

import java.time.LocalDate;

import com.on.blackonline.persistences.entities.RoleEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRegisterRequest {
    String firstName;
    String lastName;
    String gender;
    String phone;
    LocalDate dateOfBirth;
    String email;
    String password;
    String address;
    RoleEntity role;
}
