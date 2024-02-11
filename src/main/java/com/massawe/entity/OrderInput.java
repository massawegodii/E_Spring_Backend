package com.massawe.entity;

import lombok.Data;

import java.util.List;

@Data
public class OrderInput {
    private String fullName;
    private String fullAddress;
    private String contactNumber;
    private String alternateContactNumber;
    private String transactionId;
    private List<OrderProductQuantity> orderProductQuantityList;
}
