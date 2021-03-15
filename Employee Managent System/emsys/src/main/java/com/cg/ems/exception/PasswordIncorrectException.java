package com.cg.ems.exception;

public class PasswordIncorrectException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public PasswordIncorrectException(String message) {
		super(message);
	}
	
	public PasswordIncorrectException() {
		
	}

}



