package com.ies.repository.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GenericException extends RuntimeException {

	private static final long serialVersionUID = 1L;

    public static final String USER_NOT_FOUND = "Usuer not found!";

    public GenericException(final String message) {
        super(message);
    }
}
