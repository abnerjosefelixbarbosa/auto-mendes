package com.auto_mendes.backend.mapper;

import com.auto_mendes.backend.model.dto.request.EmployeeRequestDTO;
import com.auto_mendes.backend.model.dto.response.EmployeeResponseDTO;
import com.auto_mendes.backend.model.entity.AssistantManager;
import com.auto_mendes.backend.model.entity.Manager;
import com.auto_mendes.backend.model.entity.Saler;

public interface EmployeeMapper {
	Manager toManager(EmployeeRequestDTO dto);

	AssistantManager toAssistantManager(EmployeeRequestDTO dto);

	Saler toSaler(EmployeeRequestDTO dto);
	
	EmployeeResponseDTO toEmployeeResponseDTO(Manager entity);
	
	EmployeeResponseDTO toEmployeeResponseDTO(AssistantManager entity);
	
	EmployeeResponseDTO toEmployeeResponseDTO(Saler entity);
}