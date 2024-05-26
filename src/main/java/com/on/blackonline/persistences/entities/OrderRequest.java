package com.on.blackonline.persistences.entities;

import java.time.LocalDate;

import lombok.Data;

@Data
public class OrderRequest {

    private LocalDate deliveryDate;

    private String reference;

    private String status;

    private Long quoteId; 
}
