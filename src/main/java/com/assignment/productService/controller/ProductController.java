package com.assignment.productService.controller;
import com.assignment.productService.exception.ResourceNotFoundException;
import com.assignment.productService.model.Product;
import com.assignment.productService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public List<Product> getAllProduct(){
		return productService.getAllProduct();
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable long id){
		try {
			return ResponseEntity.ok().body(productService.getProductById(id));
		}
		catch (ResourceNotFoundException exception) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/product")
	public Product createProduct(@RequestBody Product product){
		return productService.createProduct(product);
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product product){
		try {
			product.setId(id);
			return ResponseEntity.ok().body(productService.updateProduct(product));
		} catch (ResourceNotFoundException exception) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/product/{id}")
	public ResponseEntity deleteProduct(@PathVariable long id){
		try {
			productService.deleteProduct(id);
			return ResponseEntity.noContent().build();
		} catch (ResourceNotFoundException exception) {
			return ResponseEntity.notFound().build();
		}
	}
}
