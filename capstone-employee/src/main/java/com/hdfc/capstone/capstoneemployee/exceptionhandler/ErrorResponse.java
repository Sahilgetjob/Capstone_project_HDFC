package com.hdfc.capstone.capstoneemployee.exceptionhandler;


//helper class for streamlining error responses
public class ErrorResponse {

	private String errorCode;
	private String errorMessage;
	
	public ErrorResponse(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	
	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	
	
}
