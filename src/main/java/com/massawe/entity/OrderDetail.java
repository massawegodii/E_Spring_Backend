package com.massawe.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;
    private String orderFullName;
    private String orderFullAddress;
    private String orderContactNumber;
    private String orderAlternateContactNumber;
    private String orderStatus;
    private Double orderAmount;
    private String transactionId;
    @OneToOne
    private Product product;
    @OneToOne
    private User user;

    public OrderDetail() {

    }
    public OrderDetail(String orderFullName, String orderFullAddress, String orderContactNumber, String orderAlternateContactNumber, String orderStatus, Double orderAmount, Product product, User user, String transactionId) {
        this.orderFullName = orderFullName;
        this.orderFullAddress = orderFullAddress;
        this.orderContactNumber = orderContactNumber;
        this.orderAlternateContactNumber = orderAlternateContactNumber;
        this.orderStatus = orderStatus;
        this.orderAmount = orderAmount;
        this.product = product;
        this.user = user;
        this.transactionId = transactionId;
    }


}
