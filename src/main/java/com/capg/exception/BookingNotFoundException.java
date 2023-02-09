package com.capg.exception;

public class BookingNotFoundException extends RuntimeException{
	  private String message;
	  public BookingNotFoundException(String message) {
super(message); 
this.message=message;
}
	  public BookingNotFoundException() {

}
}