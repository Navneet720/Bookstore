package com.example.bookstore.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    private int orderId;

    private String orderDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products = new ArrayList<>();

    public Order() {}

    public Order(int orderId, String orderDate, List<Product> products) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.products = products;
    }


}