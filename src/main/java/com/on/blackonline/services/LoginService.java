package com.on.blackonline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.on.blackonline.persistences.entities.LoginEntity;
import com.on.blackonline.persistences.repositories.LoginRepository;

@Service
public class LoginService {

    @Autowired
    LoginRepository loginRepository;

    public LoginEntity getLogin(Long id){
        return loginRepository.findById(id).get();
    }

    public List<LoginEntity> getLogins(){
        return loginRepository.findAll();
    }
    
    public LoginEntity saveLogin(LoginEntity login){
        return loginRepository.save(login);
    }

    public LoginEntity updateLogin(LoginEntity request, Long id){
        LoginEntity login = loginRepository.findById(id).get();

        login.setCreatedAt(request.getCreatedAt());
        login.setEmployee(request.getEmployee());

        return loginRepository.save(login);
    }

    public void deleteLogin(Long id){
        loginRepository.deleteById(id);
    }
}
