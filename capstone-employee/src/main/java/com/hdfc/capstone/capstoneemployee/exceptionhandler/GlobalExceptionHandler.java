package com.hdfc.capstone.capstoneemployee.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	//For handling Invalid ID exception
	@ExceptionHandler(InvalidEmployeeIDException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handleInvalidEmployeeIDException(InvalidEmployeeIDException ex) {
		return new ErrorResponse("404", ex.getMessage());
	}
	
	
	//For handling any other exception in the java project
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse handlerInternalServerExceptions() {
		return new ErrorResponse("500", "Internal Server Error");
	}
}
