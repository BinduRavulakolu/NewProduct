package com.capgemini.product.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.capgemini.product.entities.Product;

public interface ProductRepository extends MongoRepository<Product, Integer>{

	@Query("{'productName':{$regex:?0}}")
	public List<Product> findByProductName(String productName);
}
