package com.org.auto_mendes_back_end_spring_boot_java.controllers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.ExceptionResponse;
import com.org.auto_mendes_back_end_spring_boot_java.exceptions.BusinessRuleException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionController {
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});

		return errors;
	}

	@ExceptionHandler(BusinessRuleException.class)
	public ResponseEntity<ExceptionResponse> handleBusinessException(BusinessRuleException e,
			HttpServletRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setLocalDateTime(LocalDateTime.now());
		exceptionResponse.setStatus(400);
		exceptionResponse.setMessage(e.getMessage());
		exceptionResponse.setPath(request.getRequestURI());

		return ResponseEntity.status(400).body(exceptionResponse);
	}
}