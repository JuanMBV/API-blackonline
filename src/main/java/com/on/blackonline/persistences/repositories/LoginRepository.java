package com.on.blackonline.persistences.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.on.blackonline.persistences.entities.LoginEntity;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Long>{
  
}
