package com.capg.exception;

public class MovieNotFoundException extends RuntimeException{
	private String message;
	public MovieNotFoundException (String message) {
		super(message);
		this.message=message;
	}
	public MovieNotFoundException() {
		
	}
}
