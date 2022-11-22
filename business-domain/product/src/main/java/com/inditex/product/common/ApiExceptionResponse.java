package com.inditex.product.common;


public class ApiExceptionResponse {

	private String message; 
	
	public ApiExceptionResponse(String message) {
		super();
		this.message=message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
