package com.massawe.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cartId;
    @OneToOne
    private Product product;
    @OneToOne
    private User user;

    public Cart() {

    }

    public Cart(Product product, User user) {
        this.product = product;
        this.user = user;
    }
}
