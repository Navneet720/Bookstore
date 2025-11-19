package com.example.bookstore.controller;

import com.example.bookstore.model.Product;
import com.example.bookstore.service.ProductService;
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
@RequestMapping("/api/v1/products")
@Tag(name = "Product Controller", description = "APIs for managing products in the bookstore")
public class ProductController {

        private final ProductService service;

        public ProductController(ProductService service) {
                this.service = service;
        }

        @PostMapping
        @Operation(summary = "Create a product", description = "Add a new product to the store")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "201", description = "Product created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class))),
                        @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content)
        })
        public Product createProduct(@RequestBody Product product) {
                return service.create(product);
        }

        @GetMapping
        @Operation(summary = "Get all products", description = "Retrieve a list of all available products")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "List of products", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)))
        })
        public List<Product> getAllProducts() {
                return service.getAll();
        }

        @GetMapping("/{id}")
        @Operation(summary = "Get product by ID", description = "Retrieve product details by its ID")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Product found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class))),
                        @ApiResponse(responseCode = "404", description = "Product not found", content = @Content)
        })
        public Product getProductById(
                        @Parameter(description = "ID of the product to retrieve", example = "201") @PathVariable int id) {
                return service.getById(id);
        }

        @PutMapping("/{id}")
        @Operation(summary = "Update a product", description = "Update details of an existing product by ID")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Product updated successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class))),
                        @ApiResponse(responseCode = "404", description = "Product not found", content = @Content)
        })
        public Product updateProduct(
                        @Parameter(description = "ID of the product to update", example = "201") @PathVariable int id,
                        @RequestBody Product product) {
                return service.update(id, product);
        }

        @DeleteMapping("/{id}")
        @Operation(summary = "Delete a product", description = "Delete a product from the store by its ID")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "204", description = "Product deleted successfully"),
                        @ApiResponse(responseCode = "404", description = "Product not found", content = @Content)
        })
        public void deleteProduct(
                        @Parameter(description = "ID of the product to delete", example = "201") @PathVariable int id) {
                service.delete(id);
        }
}