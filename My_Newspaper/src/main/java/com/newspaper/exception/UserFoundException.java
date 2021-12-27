package com.newspaper.exception;

public class UserFoundException extends Exception {

	public UserFoundException() {
		super("User with this Username is already in DB !!!");
	}
	
	public UserFoundException(String msg) {super(msg);}
	
	
}
