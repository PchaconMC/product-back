package com.inditex.product.exception;


import java.net.UnknownHostException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.inditex.product.common.ApiExceptionResponse;

import feign.FeignException;
import feign.RetryableException;

@RestControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(RetryableException.class)
	public ResponseEntity<ApiExceptionResponse> handleRetryableException(RetryableException ex){
		ApiExceptionResponse response = new ApiExceptionResponse("Conexion error, there is no communication with the api.");
		return new ResponseEntity<ApiExceptionResponse>(response,HttpStatus.PARTIAL_CONTENT);
	}
	
	@ExceptionHandler(UnknownHostException.class)
	public ResponseEntity<ApiExceptionResponse> handleUnknownHostException(UnknownHostException ex){
		ApiExceptionResponse response = new ApiExceptionResponse("unknown error");
		return new ResponseEntity<ApiExceptionResponse>(response,HttpStatus.PARTIAL_CONTENT);
	}
		
	@ExceptionHandler(FeignException.class)
	public ResponseEntity<ApiExceptionResponse> handleBussinesException(FeignException ex){
		ApiExceptionResponse response = new ApiExceptionResponse("Product Not found");
		return new ResponseEntity<ApiExceptionResponse>(response,HttpStatus.NOT_FOUND);
	}
}
