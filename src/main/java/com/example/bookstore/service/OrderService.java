package com.example.bookstore.service;

import com.example.bookstore.dto.OrderDTO;
import com.example.bookstore.dto.ProductDTO;

import com.example.bookstore.model.Order;
import com.example.bookstore.model.Product;
import com.example.bookstore.repository.OrderRepository;
import com.example.bookstore.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderService {

    private final OrderRepository orderRepo;
    private final ProductRepository productRepo;

    public OrderService(OrderRepository orderRepo, ProductRepository productRepo) {
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
    }

    public Order createOrder(OrderDTO dto) {
        System.out.println(dto + " -------heŷ");
        Order order = new Order();
        order.setOrderId(dto.getOrderId());
        order.setOrderDate(dto.getOrderDate());
        List<Integer> list = new ArrayList<>();
        for (ProductDTO p : dto.getProducts()) {
//p.getProductId();
            System.out.println(p.getProductId());
            list.add(p.getProductId());
            System.out.println("list====>" + list);
        }

        // Fetch product entities by their IDs
        List<Integer> ids = dto.getProducts()
                .stream()
                .map(ProductDTO::getProductId)
                .collect(Collectors.toList());
        System.out.println(ids + "---ids");
        List<Product> products = productRepo.findAllById(ids);


//        List<Product> products = productRepo.findAllById(dto.getProductIds());
        System.out.println(products);
        order.setProducts(products);

        return orderRepo.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    public Order getOrderById(int id) {
        return orderRepo.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public Order updateOrder(int id, OrderDTO dto) {
        Order existing = getOrderById(id);
        existing.setOrderDate(dto.getOrderDate());
        List<Integer> productIds = dto.getProducts()
                .stream()
                .map(ProductDTO::getProductId)
                .collect(Collectors.toList());

        existing.setProducts(productRepo.findAllById(productIds));
//        existing.setProducts(productRepo.findAllById(dto.getProductIds()));
        return orderRepo.save(existing);
    }

    public void deleteOrder(int id) {
        orderRepo.deleteById(id);
    }
}