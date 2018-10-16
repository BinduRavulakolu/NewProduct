package com.capgemini.product.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.product.entities.Product;
import com.capgemini.product.repository.ProductRepository;
import com.capgemini.product.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {

		return productRepository.save(product);
	}

	@Override
	public Product findProductById(int productId) {
		Optional<Product> optionalProduct = productRepository.findById(productId);
		return optionalProduct.get();
	}

	@Override
	public Product updateProduct(Product product) {

		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);
	}

	@Override
	public List<Product> findProductByName(String productName) {
		List<Product> product= productRepository.findByProductName(productName);
	return product;
		
	}

}
