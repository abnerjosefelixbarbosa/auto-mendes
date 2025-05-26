package com.auto_mendes.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.auto_mendes.backend.dto.EmployeeRequestDTO;
import com.auto_mendes.backend.dto.EmployeeResponseDTO;

public interface IEmployeeService {
	EmployeeResponseDTO registerEmployee(EmployeeRequestDTO dto);
	
	EmployeeResponseDTO updateEmployeeById(String id, EmployeeRequestDTO dto);
	
	Page<EmployeeResponseDTO> listEmployees(Pageable pageable);
}