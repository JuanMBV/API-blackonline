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

import com.on.blackonline.persistences.entities.LoginEntity;
import com.on.blackonline.services.LoginService;

@RestController
@RequestMapping("/api/logins")
public class LoginController {

	@Autowired
	LoginService loginService;

	@GetMapping("/{id}")
	public LoginEntity getLogin(@PathVariable Long id) {
		return loginService.getLogin(id);
	}

	@GetMapping
	public List<LoginEntity> getLogins() {
		return loginService.getLogins();
	}
	
	@PostMapping
	public LoginEntity saveLogin(@RequestBody LoginEntity login) {
		return loginService.saveLogin(login);
	}
	
	@PutMapping("/{id}")
	public LoginEntity updateLogin(@RequestBody LoginEntity request, @PathVariable Long id) {
		return loginService.updateLogin(request, id);
	}

	@DeleteMapping("/{id}")
	public void deleteLogin(@PathVariable Long id) {
		loginService.deleteLogin(id);
	}
}
