package com.atos.mediatheque.handlerException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
//	public UserNotFountException ( String criteria) {
//		super("No such user: " + criteria);
//
//	}
}
