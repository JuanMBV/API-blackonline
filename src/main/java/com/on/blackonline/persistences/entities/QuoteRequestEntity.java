package com.on.blackonline.persistences.entities;

import lombok.Data;

@Data
public class QuoteRequestEntity{

    private int totalPrice;

    private int advancePayment;

    private Long clientId;

    private Long workId;
} 