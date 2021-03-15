package com.cg.ems.exception;

public class UserCredentialsInvalidException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserCredentialsInvalidException(String message) {
		super(message);
	}
	
	public UserCredentialsInvalidException() {
		
	}
}