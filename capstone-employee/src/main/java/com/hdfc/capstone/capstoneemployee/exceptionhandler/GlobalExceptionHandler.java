package com.hdfc.capstone.capstoneemployee.exceptionhandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@RestControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	//For handling Invalid ID exception
	@ExceptionHandler(InvalidEmployeeIDException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handleInvalidEmployeeIDException(InvalidEmployeeIDException ex) {
		return new ErrorResponse("404", ex.getMessage());
	}
	
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handleMethodArgumentMismatchException(MethodArgumentTypeMismatchException ex) {
		String errorMessage = ex.getErrorCode() +", "+ ex.getMessage();
		logger.warn(errorMessage);
		return new ErrorResponse(ex.getErrorCode(), ex.getMessage() );
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse handleGlobalExceptions(Exception ex) {
		logger.warn("Internal Server Error: {}", ex.getMessage());
		return new ErrorResponse("500", "Internal Server Error");
	}
}
