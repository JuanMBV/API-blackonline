package com.on.blackonline.persistences.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.on.blackonline.persistences.entities.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long>{

  List<OrderEntity> findByStatus(String status);
  
}
