package com.abc.cowin1.exception;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String msg) {
		super(msg);
	}
}