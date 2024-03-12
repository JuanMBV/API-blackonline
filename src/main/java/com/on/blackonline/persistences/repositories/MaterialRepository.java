package com.on.blackonline.persistences.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.on.blackonline.persistences.entities.MaterialEntity;

public interface MaterialRepository extends JpaRepository<MaterialEntity, Long>{
  
}
