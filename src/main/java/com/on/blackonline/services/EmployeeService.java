package com.on.blackonline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.on.blackonline.persistences.entities.EmployeeEntity;
import com.on.blackonline.persistences.repositories.EmployeeRepository;

@Service
public class EmployeeService {  
    
    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeEntity getEmployee(Long id){
        return employeeRepository.findById(id).get();
    }

    public List<EmployeeEntity> getEmployees(){
        return employeeRepository.findAll();
    }

    public EmployeeEntity saveEmployee(EmployeeEntity employee){
        return employeeRepository.save(employee);
    }

    public EmployeeEntity updateEmployee(EmployeeEntity request, Long id){
        EmployeeEntity employee = employeeRepository.findById(id).get();

        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setGender(request.getGender());
        employee.setDateOfBirth(request.getDateOfBirth());
        employee.setPhone(request.getPhone());
        employee.setEmail(request.getEmail());
        employee.setAddress(request.getAddress());
        employee.setPassword(request.getPassword());
        employee.setRole(request.getRole());
        employee.setStatus(request.getStatus());
        employee.setUpdatedAt(request.getUpdatedAt());
        employee.setCreatedAt(request.getCreatedAt());

        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }
}
