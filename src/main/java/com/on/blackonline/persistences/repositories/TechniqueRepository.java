package com.on.blackonline.persistences.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.on.blackonline.persistences.entities.TechniqueEntity;

@Repository
public interface TechniqueRepository extends JpaRepository<TechniqueEntity, Long>{
  
}
