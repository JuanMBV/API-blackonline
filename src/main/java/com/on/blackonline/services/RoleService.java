package com.on.blackonline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.on.blackonline.persistences.entities.RoleEntity;
import com.on.blackonline.persistences.repositories.RoleRepository;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public RoleEntity getRole(Long id){
        return roleRepository.findById(id).get();
    }

    public List<RoleEntity> getRoles(){
        return roleRepository.findAll();
    }

    public RoleEntity saveRole(RoleEntity role){
        return roleRepository.save(role);
    }

    public RoleEntity updateRole(RoleEntity request, Long id){
        RoleEntity role = roleRepository.findById(id).get();

        role.setName(request.getName());

        return roleRepository.save(role);
    }

    public void deleteRole(Long id){
        roleRepository.deleteById(id);
    }
}
