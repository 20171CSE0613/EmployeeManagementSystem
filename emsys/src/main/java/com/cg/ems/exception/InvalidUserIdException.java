package com.cg.ems.exception;

public class InvalidUserIdException extends RuntimeException{
	
	
	private static final long serialVersionUID = 1L;

	public InvalidUserIdException(String message) {
		super(message);
	}
	
	public InvalidUserIdException() {
		
	}

}
