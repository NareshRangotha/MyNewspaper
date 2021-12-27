package com.newspaper.exception;

public class UserNotFoundException extends Exception {
	
	public UserNotFoundException() {
		super("User with this Username not found in the Db !!");
	}
	
	public UserNotFoundException(String msg) {super(msg);}
	
	

}
