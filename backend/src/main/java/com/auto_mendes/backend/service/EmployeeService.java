package com.auto_mendes.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.auto_mendes.backend.dto.request.AssistantManagerRequestDTO;
import com.auto_mendes.backend.dto.request.EmployeeRequestDTO;
import com.auto_mendes.backend.dto.request.ManagerRequestDTO;
import com.auto_mendes.backend.dto.request.SalerRequestDTO;
import com.auto_mendes.backend.dto.response.AssistantManagerResponseDTO;
import com.auto_mendes.backend.dto.response.EmployeeResponseDTO;
import com.auto_mendes.backend.dto.response.ManagerResponseDTO;
import com.auto_mendes.backend.dto.response.SalerResponseDTO;
import com.auto_mendes.backend.enums.EmployeeType;

public interface EmployeeService {
	EmployeeResponseDTO registerEmployee(EmployeeRequestDTO dto);
	
	ManagerResponseDTO registerManager(ManagerRequestDTO dto);
	
	AssistantManagerResponseDTO registerAssistantManager(AssistantManagerRequestDTO dto);
	
	SalerResponseDTO registerSaler(SalerRequestDTO dto);
	
	EmployeeResponseDTO updateEmployeeById(String id, EmployeeRequestDTO dto);
	
	Page<EmployeeResponseDTO> listEmployeeByType(EmployeeType type, Pageable pageable);
}