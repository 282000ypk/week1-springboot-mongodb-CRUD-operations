package com.assignment.productService.ProductServiceTest;

import com.assignment.productService.repository.ProductRepository;
import com.assignment.productService.service.ProductService;
import com.assignment.productService.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @Test
    public void createProductTest(){
        Product product1 = new Product(1,"Books", "Reading Material");
        productService.createProduct(product1);
        Product product2 = productRepository.findByName("Books");
        Assertions.assertEquals(product2.getName(), product1.getName());
        Assertions.assertEquals(product2.getDescription(), product1.getDescription());
    }

    @Test
    public void updateProductTest(){
        String description = "Updated Description";
        Product product1 = productRepository.findById(1L).orElse(new Product(1,"Books", "Reading Material"));
        product1.setDescription(description);
        Product product2 = productService.updateProduct(product1);
        Assertions.assertEquals(product2.getDescription(), description);
    }

    @Test
    public void deleteProductTest(){
        Product product = productRepository.findById(1L).orElse(new Product(1,"Books", "Reading Material"));
        productService.deleteProduct(product.getId());
        product = productRepository.findById(1L).orElse(null);
        Assertions.assertEquals(product, null);
    }
}
