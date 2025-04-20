package com.example.bookstore.service;

import com.example.bookstore.dto.CustomerDTO;
import com.example.bookstore.model.Customer;
import com.example.bookstore.repository.CustomerRepository;
import com.example.bookstore.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Service
public class CustomerService {
    private final CustomerRepository customerRepo;
    private final ProductRepository productRepo;

    public CustomerService(CustomerRepository customerRepo, ProductRepository productRepo) {
        this.customerRepo = customerRepo;
        this.productRepo = productRepo;
    }

    public CustomerDTO createCustomer(CustomerDTO dto) {
        Customer customer = CustomerMapper.toEntity(dto, productRepo);
        Customer saved = customerRepo.save(customer);
        return CustomerMapper.toDTO(saved);
    }

    public CustomerDTO getById(int id) {
        Customer customer = customerRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return CustomerMapper.toDTO(customer);
    }

    public List<CustomerDTO> getAll() {
        log.info("CustomerDTO");
        return customerRepo.findAll()
                .stream()
                .map(CustomerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CustomerDTO updateCustomer(int id, CustomerDTO dto) {
        Customer existing = customerRepo.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));

        existing.setName(dto.getName());

        if (dto.getOrders() != null) {
            existing.setOrders(CustomerMapper.mapOrdersFromDTO(dto.getOrders(), productRepo));
        }

        return CustomerMapper.toDTO(customerRepo.save(existing));
    }

    public void deleteCustomer(int id) {
        customerRepo.deleteById(id);
    }
}



