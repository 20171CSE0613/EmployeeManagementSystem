package com.cg.ems.exception;

import java.util.Date;

import javax.xml.bind.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public final ResponseEntity<Object> handleNotFoundException(EmployeeNotFoundException ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND.value(), new Date(),
				ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(ValidationException.class)
	public final ResponseEntity<Object> handleValidationException(ValidationException ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), new Date(),
				ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.UNPROCESSABLE_ENTITY);

	}

	
	@ExceptionHandler(DeletionException.class)
	public final ResponseEntity<Object> handleDeletionException(DeletionException ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.CONFLICT.value(), new Date(),
				ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);

	}
}
