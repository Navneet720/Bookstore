package com.example.bookstore.controller;

import com.example.bookstore.dto.OrderDTO;
import com.example.bookstore.model.Order;
import com.example.bookstore.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@Tag(name = "Order Controller", description = "APIs to manage orders in the bookstore")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Create a new order", description = "Create a new order with customer and product info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Order created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Order.class))),
            @ApiResponse(responseCode = "400", description = "Invalid data provided", content = @Content)
    })
    public Order createOrder(@RequestBody OrderDTO dto) {
        System.out.println(dto);
        return service.createOrder(dto);
    }

    @GetMapping
    @Operation(summary = "Get all orders", description = "Retrieve all orders from the system")
    @ApiResponse(responseCode = "200", description = "List of orders", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Order.class)))
    public List<Order> getAllOrders() {
        return service.getAllOrders();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get order by ID", description = "Retrieve a specific order by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Order.class))),
            @ApiResponse(responseCode = "404", description = "Order not found", content = @Content)
    })
    public Order getOrderById(@PathVariable int id) {
        return service.getOrderById(id);
    }
}