package com.example.bookstore.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
public class Customer {

    @Id
    private int customerId;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private List<Order> orders = new ArrayList<>();

    public Customer() {}

    public Customer(int customerId, String name, List<Order> orders) {
        this.customerId = customerId;
        this.name = name;
        this.orders = orders;
    }


}