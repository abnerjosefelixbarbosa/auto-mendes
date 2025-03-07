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

import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.ExceptionResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.exceptions.NotFoundException;
import com.org.auto_mendes_back_end_spring_boot_java.exceptions.ValidationException;

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
	
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<ExceptionResponseDTO> handleValidationException(ValidationException e, HttpServletRequest request) {
		ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO();
		exceptionResponseDTO.setLocalDateTime(LocalDateTime.now());
		exceptionResponseDTO.setMessage(e.getMessage());
		exceptionResponseDTO.setPath(request.getRequestURI());
		exceptionResponseDTO.setStatus(400);
		
		return ResponseEntity.status(400).body(exceptionResponseDTO);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ExceptionResponseDTO> handleNotFoundException(NotFoundException e, HttpServletRequest request) {
		ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO();
		exceptionResponseDTO.setLocalDateTime(LocalDateTime.now());
		exceptionResponseDTO.setMessage(e.getMessage());
		exceptionResponseDTO.setPath(request.getRequestURI());
		exceptionResponseDTO.setStatus(404);
		
		return ResponseEntity.status(404).body(exceptionResponseDTO);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponseDTO> handleException(NotFoundException e, HttpServletRequest request) {
		ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO();
		exceptionResponseDTO.setLocalDateTime(LocalDateTime.now());
		exceptionResponseDTO.setMessage(e.getMessage());
		exceptionResponseDTO.setPath(request.getRequestURI());
		exceptionResponseDTO.setStatus(500);
		
		return ResponseEntity.status(500).body(exceptionResponseDTO);
	}
}