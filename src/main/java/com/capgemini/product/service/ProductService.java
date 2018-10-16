package com.capgemini.product.service;

import java.util.List;

import com.capgemini.product.entities.Product;

public interface ProductService {
	
	public Product addProduct(Product product);
	public Product findProductById(int productId);
	public Product updateProduct(Product product);
	public void deleteProduct(int productId);
	public List<Product> findProductByName(String productName);

}
