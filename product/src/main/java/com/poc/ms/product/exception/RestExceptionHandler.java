package com.poc.ms.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ApiErrorResponse handleNotFoundException(ProductNotFoundException ex) {

		ApiErrorResponse response = new ApiErrorResponse.ApiErrorResponseBuilder()
				.withStatus(HttpStatus.NOT_FOUND)
				.withMessage(ex.getMessage()).build();

		return response;
	}
	
}
