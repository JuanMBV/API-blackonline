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

import com.on.blackonline.persistences.entities.ClientEntity;
import com.on.blackonline.services.ClientService;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired 
    ClientService clientService;

    @GetMapping("/{id}")
    public ClientEntity getClient(@PathVariable Long id) {
        return clientService.getClient(id);
    }

    @GetMapping
    public List<ClientEntity> getClients() {
        return clientService.getClients();
    }

    @PostMapping
    public ClientEntity saveClient(@RequestBody ClientEntity client) {
        return clientService.saveClient(client);
    }

    @PutMapping("/{id}")
    public ClientEntity updateClient(@RequestBody ClientEntity request, @PathVariable Long id) {
        return clientService.updateClient(request, id);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}
