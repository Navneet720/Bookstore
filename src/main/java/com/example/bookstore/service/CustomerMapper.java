package com.example.bookstore.service;

import com.example.bookstore.dto.CustomerDTO;
import com.example.bookstore.dto.OrderDTO;
import com.example.bookstore.dto.ProductDTO;
import com.example.bookstore.model.Customer;
import com.example.bookstore.model.Order;
import com.example.bookstore.model.Product;
import com.example.bookstore.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


    public class CustomerMapper {

        public static CustomerDTO toDTO(Customer customer) {
            List<OrderDTO> orderDTOs = customer.getOrders().stream().map(order -> {
                List<ProductDTO> productDTOs = order.getProducts().stream()
                        .map(p -> new ProductDTO(p.getProductId(), p.getProductName(), p.getPrice()))
                        .collect(Collectors.toList());

                return new OrderDTO(order.getOrderId(), order.getOrderDate(), productDTOs);
            }).collect(Collectors.toList());

            return new CustomerDTO(customer.getCustomerId(), customer.getName(), orderDTOs);
        }

        public static Customer toEntity(CustomerDTO dto, ProductRepository productRepo) {
            Customer customer = new Customer();
            customer.setCustomerId(dto.getCustomerId());
            customer.setName(dto.getName());

            customer.setOrders(mapOrdersFromDTO(dto.getOrders(), productRepo));

            return customer;
        }

        public static List<Order> mapOrdersFromDTO(List<OrderDTO> orderDTOs, ProductRepository productRepo) {
            if (orderDTOs == null) return new ArrayList<>();

            return orderDTOs.stream().map(orderDTO -> {
                Order order = new Order();
                order.setOrderId(orderDTO.getOrderId());
                order.setOrderDate(orderDTO.getOrderDate());

                List<Integer> ids = orderDTO.getProducts().stream()
                        .map(ProductDTO::getProductId)
                        .collect(Collectors.toList());

                List<Product> products = productRepo.findAllById(ids);
                order.setProducts(products);

                return order;
            }).collect(Collectors.toList());
        }
    }
