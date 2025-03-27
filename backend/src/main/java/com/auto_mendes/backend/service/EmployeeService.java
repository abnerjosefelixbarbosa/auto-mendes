package com.auto_mendes.backend.service;

import com.auto_mendes.backend.dto.request.EmployeeRequestDTO;
import com.auto_mendes.backend.dto.response.EmployeeResponseDTO;

public interface EmployeeService {
	EmployeeResponseDTO registerEmployee(EmployeeRequestDTO dto);
}