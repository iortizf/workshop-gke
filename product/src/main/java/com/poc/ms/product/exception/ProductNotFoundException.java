package com.poc.ms.product.exception;

public class ProductNotFoundException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3067469249763161542L;

	public ProductNotFoundException(String msg){
		super(msg);
	}

}
