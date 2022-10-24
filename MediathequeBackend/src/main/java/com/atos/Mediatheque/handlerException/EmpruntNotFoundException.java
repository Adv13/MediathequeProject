package com.atos.Mediatheque.handlerException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmpruntNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
