package com.capg.exception;

public class ShowNotFoundException extends RuntimeException{
	private String message;
	public ShowNotFoundException (String message) {
		super(message);
		this.message=message;
	}
	public ShowNotFoundException() {
		
	}
}