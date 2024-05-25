package com.on.blackonline.persistences.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.on.blackonline.persistences.entities.QuoteEntity;

@Repository
public interface QuoteRepository extends JpaRepository<QuoteEntity, Long>{

  List<QuoteEntity> findByStatus(boolean b);
  
}
