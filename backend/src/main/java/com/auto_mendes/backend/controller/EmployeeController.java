package com.auto_mendes.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.auto_mendes.backend.dto.EmployeeRequestDTO;
import com.auto_mendes.backend.dto.EmployeeResponseDTO;
import com.auto_mendes.backend.service.IEmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	@Autowired
	private IEmployeeService employeeService;

	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping("/register-employee")
	public ResponseEntity<EmployeeResponseDTO> registerEmployee(@RequestBody @Valid EmployeeRequestDTO dto) {
		EmployeeResponseDTO response = employeeService.registerEmployee(dto);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@ResponseStatus(value = HttpStatus.OK)
	@PutMapping("/update-employee-id/{id}")
	public ResponseEntity<EmployeeResponseDTO> updateEmployeeById(@PathVariable String id,
			@RequestBody @Valid EmployeeRequestDTO dto) {
		EmployeeResponseDTO response = employeeService.updateEmployeeById(id, dto);

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping("/list-employees")
	public ResponseEntity<List<EmployeeResponseDTO>> listEmployees(Pageable pageable) {
		Page<EmployeeResponseDTO> page = employeeService.listEmployees(pageable);

		return ResponseEntity.status(HttpStatus.OK).body(page.getContent());
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping("/get-employee-by-id")
	public ResponseEntity<EmployeeResponseDTO> getEmployeeById(@RequestParam String id) {
		EmployeeResponseDTO employeeResponseDTO = employeeService.getEmployeeById(id);

		return ResponseEntity.status(HttpStatus.OK).body(employeeResponseDTO);
	}
}