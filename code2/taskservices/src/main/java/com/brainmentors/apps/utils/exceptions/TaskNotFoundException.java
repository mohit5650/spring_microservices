package com.brainmentors.apps.utils.exceptions;

public class TaskNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	public TaskNotFoundException() {
		message = "Task Not Exist in the DB";
	}
	
	public TaskNotFoundException(String message) {
		super(message);
		this.message = message ;
	}

	@Override
	public String toString() {
		return "TaskNotFoundException [message=" + message + "]";
	}
	
	
}
