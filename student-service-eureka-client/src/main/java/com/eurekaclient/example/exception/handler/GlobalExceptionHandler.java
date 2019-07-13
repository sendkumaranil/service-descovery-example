package com.eurekaclient.example.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.eurekaclient.example.exception.ErrorResponse;
import com.eurekaclient.example.exception.ResourceNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value=ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResponseNotFound(ResourceNotFoundException exp,WebRequest request){
		
		ErrorResponse error=new ErrorResponse();
		error.setErrorCode("404");
		error.setErrorMessage(exp.getMessage());
		
		return new ResponseEntity<ErrorResponse>(error,HttpStatus.NOT_FOUND);
	}
}
