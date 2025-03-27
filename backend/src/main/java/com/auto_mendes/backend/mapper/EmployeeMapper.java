package com.auto_mendes.backend.mapper;

import org.mapstruct.Mapper;

import com.auto_mendes.backend.dto.request.EmployeeRequestDTO;
import com.auto_mendes.backend.dto.response.EmployeeResponseDTO;
import com.auto_mendes.backend.entity.AssistantManager;
import com.auto_mendes.backend.entity.Employee;
import com.auto_mendes.backend.entity.Manager;
import com.auto_mendes.backend.entity.Saler;

@Mapper
public interface EmployeeMapper {
	Employee toEmployee(EmployeeRequestDTO dto);
	
	Manager toManager(EmployeeRequestDTO dto);

	AssistantManager toAssistantManager(EmployeeRequestDTO dto);

	Saler toSaler(EmployeeRequestDTO dto);
	
	EmployeeResponseDTO toEmployeeResponseDTO(Manager manager);
	
	EmployeeResponseDTO toEmployeeResponseDTO(AssistantManager assistantManager);
	
	EmployeeResponseDTO toEmployeeResponseDTO(Saler saler);
}