package com.myaccount.advice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(UserAlreadyExists.class)
	public ResponseEntity<Object> userAlreadAvailable(UserAlreadyExists ex,WebRequest request)
	{
		Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "User Already found");
        return new ResponseEntity<>(body, HttpStatus.ALREADY_REPORTED);
	}
	
	@ExceptionHandler(UserNotExists.class)
	public ResponseEntity<Object> userNotFound(UserNotExists ex,WebRequest request)
	{
		Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "User not found");
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

}
