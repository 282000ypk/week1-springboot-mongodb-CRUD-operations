package com.assignment.productService.repository;

import com.assignment.productService.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, Long>{

    Product findByName(String name);
}
