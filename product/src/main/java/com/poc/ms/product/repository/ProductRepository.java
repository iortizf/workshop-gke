package com.poc.ms.product.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.poc.ms.product.entity.Product;
import com.poc.ms.product.exception.ProductNotFoundException;

public interface ProductRepository extends MongoRepository<Product, String> {
	
	List<Product> findByCategory(String category);
	Product findByProductId(String productId)throws ProductNotFoundException;

}
