package com.on.blackonline.persistences.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.on.blackonline.persistences.entities.ClientEntity;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long>{
    Optional<ClientEntity> findByEmail(String client); 
}
