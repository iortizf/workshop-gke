package com.poc.ms.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.ms.product.entity.Product;
import com.poc.ms.product.exception.ProductNotFoundException;
import com.poc.ms.product.repository.ProductRepository;
import com.poc.ms.product.vo.ProductVo;

@Service
public class ProductServiceImp implements ProductService {

	private static String DEFAULT_PRODUCT_ID = "";
	@Autowired
	private ProductRepository productRepository;
		
	public ProductServiceImp() {
		try {
			Product product = productRepository.findByProductId(DEFAULT_PRODUCT_ID);
			if(product==null) {//Add default products.
				defaultProducts().forEach(prodvo ->{
					addProduct(prodvo);
				});
			}
		} catch (ProductNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private List<ProductVo> defaultProducts(){
		
		List<ProductVo> defaultsProducts = new ArrayList<>();
		
		ProductVo productVo = new ProductVo();
		productVo.setProductId("OLJCESPC7Z");
		productVo.setName("Vintage Typewriter");
		productVo.setDescription("This typewriter looks good in your living room.");
		productVo.setPicture("/static/img/products/typewriter.jpg");
		productVo.setStock(50);
		productVo.setPrice(60.00);
		defaultsProducts.add(productVo);
		
		return defaultsProducts;
	}

	private List<ProductVo> buildProducts(List<Product> products) {
		if (products != null && !products.isEmpty()) {
			return products.stream().map(product -> {
				ProductVo productVo = new ProductVo();
				productVo.setProductId(product.getProductId());
				productVo.setName(product.getName());
				productVo.setDescription(product.getDescription());
				productVo.setPicture(product.getPicture());
				productVo.setStock(product.getStock());
				productVo.setPrice(product.getPrice());
				return productVo;
			}).collect(Collectors.toList());
		}

		return new ArrayList<>();
	}

	public List<ProductVo> getProducts() {
		List<Product> products = productRepository.findAll();
		return buildProducts(products);
	}

	public List<ProductVo> getProductByCategory(String category) {
		List<Product> products = productRepository.findByCategory(category);
		return buildProducts(products);
	}

	public ProductVo getByProductId(String productId) throws ProductNotFoundException{
		Product product = productRepository.findByProductId(productId);
		
		if(product==null)
			throw new ProductNotFoundException("No se encontró el producto con id "+productId+"");
		
		ProductVo productVo = new ProductVo();
		productVo.setProductId(product.getProductId());
		productVo.setName(product.getName());
		productVo.setDescription(product.getDescription());
		productVo.setPicture(product.getPicture());
		productVo.setStock(product.getStock());
		productVo.setPrice(product.getPrice());
		productVo.setCategory(product.getCategory());
		
		return productVo;
	}

	public ProductVo addProduct(ProductVo productVo) {

		Product product = new Product();
		product.setId(product.getProductId());
		product.setProductId(productVo.getProductId());
		product.setName(productVo.getName());
		product.setDescription(productVo.getDescription());
		product.setPicture(productVo.getPicture());
		product.setStock(productVo.getStock());
		product.setPrice(productVo.getPrice());
		
		product = productRepository.save(product);

		return productVo;
	}

}
