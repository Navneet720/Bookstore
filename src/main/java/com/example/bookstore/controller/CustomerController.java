package com.example.bookstore.controller;

import com.example.bookstore.dto.CustomerDTO;
import com.example.bookstore.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@Tag(name = "Customer Controller", description = "APIs to manage customers in the bookstore")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @Operation(summary = "Create a new customer", description = "Registers a new customer with basic details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content)
    })
    @PostMapping
    public CustomerDTO create(@RequestBody CustomerDTO dto) {
        return service.createCustomer(dto);
    }

    @Operation(summary = "Get customer by ID", description = "Fetch a single customer using their ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerDTO.class))),
            @ApiResponse(responseCode = "404", description = "Customer not found", content = @Content)
    })
    @GetMapping("/{id}")
    public CustomerDTO getById(
            @Parameter(description = "ID of the customer to retrieve", example = "101")
            @PathVariable int id) {
        return service.getById(id);
    }

    @Operation(summary = "Get all customers", description = "Fetch a list of all registered customers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customers retrieved successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerDTO.class)))
    })
    @GetMapping
    public List<CustomerDTO> getAll() {
        return service.getAll();
    }

    @Operation(summary = "Update an existing customer", description = "Update customer details by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer updated successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerDTO.class))),
            @ApiResponse(responseCode = "404", description = "Customer not found", content = @Content)
    })
    @PutMapping("/{id}")
    public CustomerDTO update(
            @Parameter(description = "ID of the customer to update", example = "101")
            @PathVariable int id,
            @RequestBody CustomerDTO dto) {
        return service.updateCustomer(id, dto);
    }

    @Operation(summary = "Delete a customer", description = "Delete a customer record by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Customer deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Customer not found", content = @Content)
    })
    @DeleteMapping("/{id}")
    public void delete(
            @Parameter(description = "ID of the customer to delete", example = "101")
            @PathVariable int id) {
        service.deleteCustomer(id);
    }
}