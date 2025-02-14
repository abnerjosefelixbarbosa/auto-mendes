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

import com.org.auto_mendes_back_end_spring_boot_java.dtos.ExceptionResponseDTO;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionController {
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException e) {
		Map<String, String> errors = new HashMap<>();
		
		e.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		
		return errors;
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ExceptionResponseDTO> handleRuntimeException(RuntimeException e, HttpServletRequest request) {
		ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO();
		exceptionResponseDTO.setLocalDateTime(LocalDateTime.now());
		exceptionResponseDTO.setMessage(e.getMessage());
		exceptionResponseDTO.setPath(request.getRequestURI());
		exceptionResponseDTO.setStatus(400);
		
		return ResponseEntity.status(400).body(exceptionResponseDTO);
	}
}