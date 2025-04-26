package com.auto_mendes.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.auto_mendes.backend.dto.request.EmployeeRequestDTO;
import com.auto_mendes.backend.dto.response.EmployeeResponseDTO;
import com.auto_mendes.backend.enums.EmployeeType;

public interface EmployeeService {
	EmployeeResponseDTO registerEmployee(EmployeeRequestDTO dto);

	EmployeeResponseDTO updateEmployeeById(String id, EmployeeRequestDTO dto);
	
	Page<EmployeeResponseDTO> listEmployeeByType(EmployeeType type, Pageable pageable);
	
	Page<EmployeeResponseDTO> listEmployee(Pageable pageable);
}