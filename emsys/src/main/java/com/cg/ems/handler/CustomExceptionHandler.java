package com.cg.ems.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.ems.controller.LoginController;
import com.cg.ems.exception.*;

@RestControllerAdvice
public class CustomExceptionHandler {

	private static final Logger log = LogManager.getLogger(LoginController.class);
	
	
	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<String> InvalidInputException(InvalidInputException exception)
	{
		log.error(exception.getLocalizedMessage());
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(PasswordIncorrectException.class)
	public ResponseEntity<String> PasswordIncorrectException(PasswordIncorrectException exception)
	{
		log.error(exception.getLocalizedMessage());
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidUserIdException.class)
	public ResponseEntity<String> InvalidUserIdException(InvalidUserIdException exception)
	{
		log.error(exception.getLocalizedMessage());
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(RoleNotFoundException.class)
	public ResponseEntity<String> RoleNotFoundException(RoleNotFoundException exception)
	{
		log.error(exception.getLocalizedMessage());
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class)
	public ResponseEntity<String> HttpMessageNotReadableException(org.springframework.http.converter.HttpMessageNotReadableException exception){
		log.error(exception.getLocalizedMessage());
		return new ResponseEntity<String>("Enter proper JSON format",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(org.springframework.web.HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<String> HttpRequestMethodNotSupportedException(org.springframework.web.HttpRequestMethodNotSupportedException exception){
		log.error(exception.getLocalizedMessage());
		return new ResponseEntity<String>("Mapping Mismatch",HttpStatus.NOT_FOUND);
	}

	
	
}

	
