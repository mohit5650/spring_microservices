package com.brainmentors.apps.dto;

import java.util.Date;

public class ExceptionMessage {
	private String message;
	private Date timeStamp;
	public ExceptionMessage() {}
	public ExceptionMessage(String message) {
		super();
		this.message = message;
		this.timeStamp = new Date();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	@Override
	public String toString() {
		return "ExceptionMessage [message=" + message + ", timeStamp=" + timeStamp + "]";
	}
	

}
