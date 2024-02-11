package com.massawe.entity;

import lombok.Data;

@Data
public class TransactionDetails {

    private String orderId;
    private String currency;
    private Integer amount;
    private String key;

    public TransactionDetails(String orderId, String currency, Integer amount, String key) {
        this.orderId = orderId;
        this.currency = currency;
        this.amount = amount;
        this.key = key;
    }
}
