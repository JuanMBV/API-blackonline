package com.on.blackonline.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.on.blackonline.persistences.entities.EmployeeEntity;
import com.on.blackonline.services.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/{id}")
    public EmployeeEntity getEmployee(@PathVariable Long id){
        return employeeService.getEmployee(id);
    }

    @GetMapping
    public List<EmployeeEntity> getEmployees(){
        return employeeService.getEmployees();
    }

    @PostMapping
    public EmployeeEntity saveEmployee(@RequestBody EmployeeEntity employee){
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/{id}")
    public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity employee, @PathVariable Long id){
        return employeeService.updateEmployee(employee, id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }
}
