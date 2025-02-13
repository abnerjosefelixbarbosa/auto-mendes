package com.org.auto_mendes_back_end_spring_boot_java.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.enums.EmployeeType;
import com.org.auto_mendes_back_end_spring_boot_java.services.EmployeeServiceInterface;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/employees")
public class EmployeeController {
	@Autowired
	private EmployeeServiceInterface employeeService;

	@PostMapping(value = "/register-employee")
	public ResponseEntity<Object> registerEmployee(@RequestBody @Valid EmployeeRequestDTO request) {
		Object object = employeeService.registerEmployee(request);

		return ResponseEntity.status(HttpStatus.CREATED).body(object);
	}

	@GetMapping(value = "/list-employees")
	public ResponseEntity<Page<Object>> listEmployees(Pageable pageable) {
		Page<Object> object = employeeService.listEmployees(pageable);

		return ResponseEntity.status(HttpStatus.OK).body(object);
	}

	@GetMapping(value = "/list-employees-by-position")
	public ResponseEntity<Page<Object>> listEmployeesByPosition(Pageable pageable,
			@RequestParam String employeeType) {
		Page<Object> object = employeeService.listEmployeesByPosition(pageable,
				EmployeeType.valueOf(employeeType));

		return ResponseEntity.status(HttpStatus.OK).body(object);
	}
}