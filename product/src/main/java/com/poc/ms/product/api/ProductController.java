package com.poc.ms.product.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.poc.ms.product.exception.ProductNotFoundException;
import com.poc.ms.product.service.ProductService;
import com.poc.ms.product.vo.ProductVo;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public List<ProductVo> getProducts() {
		return productService.getProducts();
	}

	@GetMapping("/{id}")
	public ProductVo getProductById(@PathVariable("id") String productId) 
			throws ProductNotFoundException {
		return productService.getByProductId(productId);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProductVo addProduct(@RequestBody ProductVo productVo) {
		return productService.addProduct(productVo);
	}
}
