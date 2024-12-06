package com.org.auto_mendes_back_end_java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.auto_mendes_back_end_java.dto.RegisterEmployeeRequest;
import com.org.auto_mendes_back_end_java.dto.RegisterEmployeeResponse;
import com.org.auto_mendes_back_end_java.service.IEmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	@Autowired
	private IEmployeeService employeeService;
	
	@PostMapping(value = "/register-employee")
	public ResponseEntity<RegisterEmployeeResponse> registerEmployee(RegisterEmployeeRequest request) {
		RegisterEmployeeResponse response = employeeService.registerEmployee(request);
		
		return ResponseEntity.status(201).body(response);
	}
}