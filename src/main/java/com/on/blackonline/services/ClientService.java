package com.on.blackonline.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.on.blackonline.persistences.entities.ClientEntity;
import com.on.blackonline.persistences.repositories.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    
    public ClientEntity getClient(Long id){
        return clientRepository.findById(id).get();
    }

    public List<ClientEntity> getClients(){
        return clientRepository.findAll();
    }

    public ClientEntity saveClient(ClientEntity client){
        return clientRepository.save(client);
    }

    public ClientEntity updateClient(ClientEntity request, Long id){
        ClientEntity client = clientRepository.findById(id).get();

        client.setFirstName(request.getFirstName());
        client.setLastName(request.getLastName());
        client.setPhone(request.getPhone());
        client.setEmail(request.getEmail());
        client.setPassword(request.getPassword());
        client.setAddress(request.getAddress());
        client.setUpdatedAt(LocalDateTime.now());

        return clientRepository.save(client);
    }

    public void deleteClient(Long id){
        clientRepository.deleteById(id);
    }
}
