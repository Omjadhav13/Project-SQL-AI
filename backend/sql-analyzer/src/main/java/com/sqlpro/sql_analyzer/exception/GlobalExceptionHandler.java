package com.sqlpro.sql_analyzer.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e) {
		return "Something wen worng." + e.getMessage();
	}
	

}
