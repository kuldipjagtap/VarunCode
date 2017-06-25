package com.yourstories.controllers.advice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.yourstories.exceptions.NoAuthorsFoundException;
import com.yourstories.exceptions.NoCategoriesFoundException;

@RestControllerAdvice
public class CategoryControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value={NoCategoriesFoundException.class})
	private ResponseEntity<?> handleCategoryNotFound(Exception ex, WebRequest req){
	if(ex instanceof NoCategoriesFoundException){
		NoCategoriesFoundException noex = (NoCategoriesFoundException) ex;
		return handleExceptionInternal(noex, noex.getMessage(), 
		          new HttpHeaders(), HttpStatus.CONFLICT, req);
	}
	 return handleExceptionInternal(ex, ex.getMessage(), 
	          new HttpHeaders(), HttpStatus.CONFLICT, req);
	}
}
