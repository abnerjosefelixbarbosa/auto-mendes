package com.org.auto_mendes_back_end_java.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@PostMapping(value = "/register-employee")
	public ResponseEntity<?> registerEmployee() {
		return ResponseEntity.status(201).body(null);
	}
}