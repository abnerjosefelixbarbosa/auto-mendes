package com.auto_mendes.backend.config;

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

import com.auto_mendes.backend.dto.response.ExceptionResponseDTO;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExcepitionConfig {
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

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ExceptionResponseDTO> handleRuntimeException(RuntimeException e, HttpServletRequest request) {
		ExceptionResponseDTO response = new ExceptionResponseDTO(LocalDateTime.now(), 400, e.getMessage(),
				request.getRequestURI());

		return ResponseEntity.status(400).body(response);
	}
	
	@ExceptionHandler(EntityExistsException.class)
	public ResponseEntity<ExceptionResponseDTO> handleEntityExistsException(EntityExistsException e, HttpServletRequest request) {
		ExceptionResponseDTO response = new ExceptionResponseDTO(LocalDateTime.now(), 400, e.getMessage(),
				request.getRequestURI());

		return ResponseEntity.status(400).body(response);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ExceptionResponseDTO> handleEntityNotFoundException(RuntimeException e, HttpServletRequest request) {
		ExceptionResponseDTO response = new ExceptionResponseDTO(LocalDateTime.now(), 404, e.getMessage(),
				request.getRequestURI());

		return ResponseEntity.status(404).body(response);
	}
}