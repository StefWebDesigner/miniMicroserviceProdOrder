package com.stefan.microservice_product_service.repositories;

import com.stefan.microservice_product_service.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>  {
}
