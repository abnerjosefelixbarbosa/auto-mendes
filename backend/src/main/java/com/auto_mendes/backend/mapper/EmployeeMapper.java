package com.auto_mendes.backend.mapper;

import org.mapstruct.Mapper;

import com.auto_mendes.backend.model.dto.request.EmployeeRequestDTO;
import com.auto_mendes.backend.model.dto.response.EmployeeResponseDTO;
import com.auto_mendes.backend.model.entity.AssistantManager;
import com.auto_mendes.backend.model.entity.Employee;
import com.auto_mendes.backend.model.entity.Manager;
import com.auto_mendes.backend.model.entity.Saler;

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