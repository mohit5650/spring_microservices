package com.brainmentors.apps.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.brainmentors.apps.dto.ExceptionMessage;
import com.brainmentors.apps.utils.exceptions.DuplicateTaskException;
import com.brainmentors.apps.utils.exceptions.ReadOnlyTaskException;
import com.brainmentors.apps.utils.exceptions.TaskNotFoundException;

@ControllerAdvice
public class TaskApplictionExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	// Generic 
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<ExceptionMessage> handleAnyException(Exception exception, WebRequest request){
		System.out.println("Inside Exception Handler "+exception);
		ExceptionMessage exceptionMessage = new ExceptionMessage(exception.getLocalizedMessage());
		return new ResponseEntity<ExceptionMessage>(exceptionMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	// Specific
	@ExceptionHandler(value = {NullPointerException.class})
	public ResponseEntity<ExceptionMessage> handleAnyException(NullPointerException exception, WebRequest request){
		System.out.println("Inside Exception Handler "+exception);
		ExceptionMessage exceptionMessage = new ExceptionMessage(exception.getLocalizedMessage());
		return new ResponseEntity<ExceptionMessage>(exceptionMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// Business Exception
	@ExceptionHandler(value = {TaskNotFoundException.class})
	public ResponseEntity<ExceptionMessage> handleAnyException(TaskNotFoundException exception, WebRequest request){
		System.out.println("Inside Exception Handler "+exception);
		ExceptionMessage exceptionMessage = new ExceptionMessage(exception.getLocalizedMessage());
		return new ResponseEntity<ExceptionMessage>(exceptionMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

	// Business Exception
	@ExceptionHandler(value = {ReadOnlyTaskException.class,DuplicateTaskException.class})
	public ResponseEntity<ExceptionMessage> handleAnyException(RuntimeException exception, WebRequest request){
		System.out.println("Inside Exception Handler "+exception);
		ExceptionMessage exceptionMessage = new ExceptionMessage(exception.getLocalizedMessage());
		return new ResponseEntity<ExceptionMessage>(exceptionMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
