package com.on.blackonline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.on.blackonline.persistences.entities.OrderEntity;
import com.on.blackonline.persistences.repositories.OrderRepository;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public OrderEntity getOrder(Long id){
        return orderRepository.findById(id).get();
    }

    public List<OrderEntity> getOrders(){
        return orderRepository.findAll();
    }

    public OrderEntity saveOrder(OrderEntity order){
        return orderRepository.save(order);
    }

    public OrderEntity updateOrder(OrderEntity request, Long id){
        OrderEntity order = orderRepository.findById(id).get();

        order.setDeliveryDate(request.getDeliveryDate());
        order.setReference(request.getReference());
        order.setStatus(request.getStatus());

        return orderRepository.save(order);
    }

    public void deleteOrder(Long id){
        orderRepository.deleteById(id);
    }
}
