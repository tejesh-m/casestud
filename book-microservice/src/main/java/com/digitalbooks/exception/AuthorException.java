package com.digitalbooks.exception;

public class AuthorException extends Exception{
	
	public AuthorException() {
		super();
		
	}

	public AuthorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public AuthorException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public AuthorException(String message) {
		super(message);
		
	}

	public AuthorException(Throwable cause) {
		super(cause);
		
	}


}
