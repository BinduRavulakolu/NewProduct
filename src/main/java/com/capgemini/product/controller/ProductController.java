package com.capgemini.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.product.entities.Product;
import com.capgemini.product.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@PostMapping("/product")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {

		ResponseEntity<Product> responseEntity = new ResponseEntity<Product>(productService.addProduct(product),
				HttpStatus.OK);
		return responseEntity;
	}
	
	
	@PutMapping("/product")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
			Product p = productService.findProductById(product.getProductId());
				return new ResponseEntity<Product>(productService.updateProduct(product), HttpStatus.OK);
	
	}
	
	@GetMapping("/product/{productId}")
	public ResponseEntity<Product> findProductById(@PathVariable int productId) {
	
			Product p = productService.findProductById(productId);
				return new ResponseEntity<Product>(p, HttpStatus.OK);
	}
	
	@GetMapping("/product/search")
	public ResponseEntity<List<Product>> findProductByName(@RequestParam String search) {
	
		
				return new ResponseEntity<List<Product>>(productService.findProductByName(search), HttpStatus.OK);
	}
	
	@DeleteMapping("/product/{productId}")
	public ResponseEntity<Product> deleteProduct(@PathVariable int productId) {
		
			Product p = productService.findProductById(productId);
				productService.deleteProduct(productId);
			return new ResponseEntity<Product>(HttpStatus.OK);
		
	}


}
