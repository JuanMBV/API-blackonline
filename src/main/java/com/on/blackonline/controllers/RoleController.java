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

import com.on.blackonline.persistences.entities.RoleEntity;
import com.on.blackonline.services.RoleService;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping("/{id}")
    public RoleEntity getRole(@PathVariable Long id){
        return roleService.getRole(id);
    }

    @GetMapping
    public List<RoleEntity> getRoles(){
        return roleService.getRoles();
    }

    @PostMapping
    public RoleEntity saveRole(@RequestBody RoleEntity role){
        return roleService.saveRole(role);
    }

    @PutMapping("/{id}")
    public RoleEntity updateRole(@RequestBody RoleEntity role, @PathVariable Long id){
        return roleService.updateRole(role, id);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id){
        roleService.deleteRole(id);
    }
}
