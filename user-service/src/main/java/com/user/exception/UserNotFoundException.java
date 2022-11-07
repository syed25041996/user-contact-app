package com.user.exception;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;

	public UserNotFoundException() {

	}

	public UserNotFoundException(String message) {
		this.message = message;
	}

}
