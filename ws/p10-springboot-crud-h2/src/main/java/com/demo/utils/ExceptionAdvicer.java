package com.demo.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvicer {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception e){
		return new ResponseEntity(e.getMessage(), HttpStatus.OK);
	}
	
}
