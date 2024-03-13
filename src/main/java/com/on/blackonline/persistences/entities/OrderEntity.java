package com.on.blackonline.persistences.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

    @Column(name = "reference")
    private String reference;

    @Column(name = "status")
    private String status;

    // Analizar employees

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;

    @ManyToOne
    @JoinColumn(name = "quote_id")
    private QuoteEntity quote; 
}
