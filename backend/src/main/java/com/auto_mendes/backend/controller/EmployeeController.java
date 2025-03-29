package com.auto_mendes.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auto_mendes.backend.dto.request.EmployeeRequestDTO;
import com.auto_mendes.backend.dto.response.EmployeeResponseDTO;
import com.auto_mendes.backend.enums.EmployeeType;
import com.auto_mendes.backend.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(value = "/register-employee")
	public ResponseEntity<EmployeeResponseDTO> registerEmployee(@Valid @RequestBody EmployeeRequestDTO dto) {
		EmployeeResponseDTO employeeResponseDTO = employeeService.registerEmployee(dto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeResponseDTO);
	}
	
	@PutMapping(value = "/update-employee-by-id")
	public ResponseEntity<EmployeeResponseDTO> updateEmployeeById(@RequestParam String id, @Valid @RequestBody EmployeeRequestDTO dto) {
		EmployeeResponseDTO employeeResponseDTO = employeeService.updateEmployeeById(id, dto);
		
		return ResponseEntity.status(HttpStatus.OK).body(employeeResponseDTO);
	}
	
	@GetMapping(value = "/list-employee-by-type")
	public ResponseEntity<Page<EmployeeResponseDTO>> listEmployeeByType(@RequestParam EmployeeType type, Pageable pageable) {
		Page<EmployeeResponseDTO> page = employeeService.listEmployeeByType(type, pageable);
		
		return ResponseEntity.status(HttpStatus.OK).body(page);
	}
}