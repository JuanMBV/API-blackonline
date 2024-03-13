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

import com.on.blackonline.persistences.entities.OrderEntity;
import com.on.blackonline.services.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/{id}")
    public OrderEntity getOrder(@PathVariable Long id){
        return orderService.getOrder(id);
    }

    @GetMapping
    public List<OrderEntity> getOrders(){
        return orderService.getOrders();
    }

    @PostMapping
    public OrderEntity saveOrder(@RequestBody OrderEntity order){
        return orderService.saveOrder(order);
    }

    @PutMapping("/{id}")
    public OrderEntity updateOrder(@RequestBody OrderEntity request, @PathVariable Long id){
        return orderService.updateOrder(request, id);
    }
 
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
    }
}
