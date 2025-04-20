package com.auto_mendes.backend.controller;

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

import com.auto_mendes.backend.dto.request.AssistantManagerRequestDTO;
import com.auto_mendes.backend.dto.request.EmployeeRequestDTO;
import com.auto_mendes.backend.dto.request.ManagerRequestDTO;
import com.auto_mendes.backend.dto.request.SalerRequestDTO;
import com.auto_mendes.backend.dto.response.AssistantManagerResponseDTO;
import com.auto_mendes.backend.dto.response.EmployeeResponseDTO;
import com.auto_mendes.backend.dto.response.ManagerResponseDTO;
import com.auto_mendes.backend.dto.response.SalerResponseDTO;
import com.auto_mendes.backend.enums.EmployeeType;
import com.auto_mendes.backend.service.EmployeeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/employees")
@RequiredArgsConstructor
public class EmployeeController {
	private final EmployeeService employeeService;
	
	@PostMapping(value = "/register-manager")
	public ResponseEntity<ManagerResponseDTO> registerManager(@Valid @RequestBody ManagerRequestDTO dto) {
		ManagerResponseDTO response = employeeService.registerManager(dto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PostMapping(value = "/register-assistant-manager")
	public ResponseEntity<AssistantManagerResponseDTO> registerAssistantManager(@Valid @RequestBody AssistantManagerRequestDTO dto) {
		AssistantManagerResponseDTO response = employeeService.registerAssistantManager(dto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PostMapping(value = "/register-saler")
	public ResponseEntity<SalerResponseDTO> registerSaler(@Valid @RequestBody SalerRequestDTO dto) {
		SalerResponseDTO response = employeeService.registerSaler(dto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PutMapping(value = "/update-employee-by-id")
	public ResponseEntity<EmployeeResponseDTO> updateEmployeeById(@RequestParam String id, @Valid @RequestBody EmployeeRequestDTO dto) {
		//EmployeeResponseDTO employeeResponseDTO = employeeService.updateEmployeeById(id, dto);
		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	@GetMapping(value = "/list-employee-by-type")
	public ResponseEntity<Page<EmployeeResponseDTO>> listEmployeeByType(@RequestParam EmployeeType type, Pageable pageable) {
		Page<EmployeeResponseDTO> page = employeeService.listEmployeeByType(type, pageable);
		
		return ResponseEntity.status(HttpStatus.OK).body(page);
	}
}