package com.stefan.microservice_product_service.controllers;

import com.stefan.microservice_product_service.entities.Product;
import com.stefan.microservice_product_service.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product result = productService.createProduct(product);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> fetchAllProducts() {
        List<Product> result = productService.getAllProducts();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Integer id) {
        return new Product(id, "Sample Product", 99.99);
    }


}
