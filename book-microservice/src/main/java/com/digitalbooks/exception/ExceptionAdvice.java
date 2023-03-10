package com.digitalbooks.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.digitalbooks.entity.ErMessage;

@ControllerAdvice
public class ExceptionAdvice {
	
	@ExceptionHandler(AuthorException.class)
	public ResponseEntity<ErMessage> handleAuthorException(AuthorException ae)
	{
		return new ResponseEntity<ErMessage>(new ErMessage(
				"AuthorException:" +ae.getMessage(),
				ae.getClass().toString(),
				"Exception has occured,Please check"),HttpStatus.OK);

	}

}
