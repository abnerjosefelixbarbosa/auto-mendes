package com.auto_mendes.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.auto_mendes.backend.model.dto.request.EmployeeRequestDTO;
import com.auto_mendes.backend.model.dto.response.EmployeeResponseDTO;
import com.auto_mendes.backend.model.enums.EmployeeType;

public interface EmployeeService {
	EmployeeResponseDTO registerEmployee(EmployeeRequestDTO dto);
	
	EmployeeResponseDTO updateEmployeeById(String id, EmployeeRequestDTO dto);
	
	Page<EmployeeResponseDTO> listEmployeeByType(EmployeeType type, Pageable pageable);
}