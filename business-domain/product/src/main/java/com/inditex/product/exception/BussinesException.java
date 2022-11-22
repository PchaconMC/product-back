package com.inditex.product.exception;

import org.springframework.http.HttpStatus;

public class BussinesException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String description;
	private HttpStatus httpStatus;
	
	public BussinesException(String description, String message, HttpStatus httpStatus) {
		super(message);
		this.description=description;
		this.httpStatus=httpStatus;
	}
	
	public BussinesException(String message, Throwable cause) {
		super(message,cause);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

}
