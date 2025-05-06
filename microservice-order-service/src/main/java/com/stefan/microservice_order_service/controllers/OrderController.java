package com.stefan.microservice_order_service.controllers;

import com.stefan.microservice_order_service.client.ProductServiceClient;
import com.stefan.microservice_order_service.entities.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private final ProductServiceClient productServiceClient;

    public OrderController(ProductServiceClient productServiceClient) {
        this.productServiceClient = productServiceClient;
    }


    @GetMapping("/allProducts")
    public ResponseEntity<List<Product>> fetchAllProducts() {
        List<Product> result = productServiceClient.fetchAllProducts();
        return new ResponseEntity<>(result, HttpStatusCode.valueOf(200));
    }
}