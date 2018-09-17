package com.poc.ms.product.service;

import java.util.List;

import com.poc.ms.product.exception.ProductNotFoundException;
import com.poc.ms.product.vo.ProductVo;

public interface ProductService{
	
	List<ProductVo> getProducts();
	List<ProductVo> getProductByCategory(String category);
	ProductVo getByProductId(String productId)throws ProductNotFoundException;
	ProductVo addProduct(ProductVo productVo);

}
