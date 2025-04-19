package com.example.bookstore.repository;

import com.example.bookstore.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface CustomerRepository extends JpaRepository<Customer, Integer> {}
//    public interface OrderRepository extends JpaRepository<Order, Integer> {}
//    public interface ProductRepository extends JpaRepository<Product, Integer> {}
