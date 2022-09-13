package com.ies.repository.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BusinessAdvice {

	@ResponseBody
	@ExceptionHandler(BusinessException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	String BusinessHandler(BusinessException ex) {
		return ex.getMessage();
	}
}
