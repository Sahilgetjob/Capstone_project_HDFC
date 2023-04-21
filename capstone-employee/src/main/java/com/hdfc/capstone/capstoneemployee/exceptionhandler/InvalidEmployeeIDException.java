package com.hdfc.capstone.capstoneemployee.exceptionhandler;

public class InvalidEmployeeIDException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidEmployeeIDException(String message) {
		super(message);
	}

}
