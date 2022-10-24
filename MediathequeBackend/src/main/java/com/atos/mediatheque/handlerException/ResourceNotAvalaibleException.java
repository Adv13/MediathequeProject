package com.atos.mediatheque.handlerException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ResourceNotAvalaibleException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
