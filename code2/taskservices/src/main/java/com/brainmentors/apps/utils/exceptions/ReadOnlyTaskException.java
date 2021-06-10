package com.brainmentors.apps.utils.exceptions;

public class ReadOnlyTaskException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	public ReadOnlyTaskException() {
		message = "ReadOnlyTask  in the DB";
	}
	
	public ReadOnlyTaskException(String message) {
		super(message);
		this.message = message ;
	}

	@Override
	public String toString() {
		return "ReadOnlyTaskException [message=" + message + "]";
	}
	
	
}
