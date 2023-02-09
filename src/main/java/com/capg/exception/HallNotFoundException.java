package com.capg.exception;

public class HallNotFoundException extends RuntimeException{
	private String message;
	public HallNotFoundException (String message) {
		super(message);
		this.message=message;
	}
	public HallNotFoundException() {
		
	}


}
