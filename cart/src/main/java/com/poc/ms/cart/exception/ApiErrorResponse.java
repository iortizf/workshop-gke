package com.poc.ms.cart.exception;

import org.springframework.http.HttpStatus;

public class ApiErrorResponse {
	
	private HttpStatus status;
	private String message;
	

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public static final class ApiErrorResponseBuilder {
		
		private HttpStatus status;
		private String message;

		ApiErrorResponseBuilder() {
			
		}

		public static ApiErrorResponseBuilder anApiErrorResponse() {
			return new ApiErrorResponseBuilder();
		}

		public ApiErrorResponseBuilder withStatus(HttpStatus status) {
			this.status = status;
			return this;
		}

		public ApiErrorResponseBuilder withMessage(String message) {
			this.message = message;
			return this;
		}

		public ApiErrorResponse build() {
			ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
			apiErrorResponse.status = this.status;
			apiErrorResponse.message = this.message;
			return apiErrorResponse;
		}
	}
}
