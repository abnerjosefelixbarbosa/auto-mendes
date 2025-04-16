package com.auto_mendes.backend.mapper;

import com.auto_mendes.backend.dto.EmployeeRequestDTO;
import com.auto_mendes.backend.dto.EmployeeResponseDTO;
import com.auto_mendes.backend.entity.AssistantManager;
import com.auto_mendes.backend.entity.Manager;
import com.auto_mendes.backend.entity.Saler;

public interface EmployeeMapper {
	Manager toManager(EmployeeRequestDTO dto);

	AssistantManager toAssistantManager(EmployeeRequestDTO dto);

	Saler toSaler(EmployeeRequestDTO dto);
	
	EmployeeResponseDTO toEmployeeResponseDTO(Manager entity);
	
	EmployeeResponseDTO toEmployeeResponseDTO(AssistantManager entity);
	
	EmployeeResponseDTO toEmployeeResponseDTO(Saler entity);
}