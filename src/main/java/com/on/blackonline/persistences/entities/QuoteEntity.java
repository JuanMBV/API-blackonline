package com.on.blackonline.persistences.entities;

import java.time.LocalDateTime;

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
@Table(name = "quotes")
public class QuoteEntity {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quote_id;

    @Column(name = "total_price")
    private int totalPrice;

    @Column(name = "quote_date")
    private LocalDateTime quoteDate;

    @Column(name = "advance_payment")
    private int advancePayment;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    @ManyToOne
    @JoinColumn(name = "work_id")
    private WorkEntity work;
}
