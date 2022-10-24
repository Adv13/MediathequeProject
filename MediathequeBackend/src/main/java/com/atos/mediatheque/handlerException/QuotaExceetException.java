package com.atos.mediatheque.handlerException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.LENGTH_REQUIRED) //a modifier ptet
public class QuotaExceetException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
