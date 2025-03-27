package com.auto_mendes.backend.mapper.impl;

import org.springframework.stereotype.Component;

import com.auto_mendes.backend.dto.request.EmployeeRequestDTO;
import com.auto_mendes.backend.dto.response.EmployeeResponseDTO;
import com.auto_mendes.backend.entity.AssistantManager;
import com.auto_mendes.backend.entity.Manager;
import com.auto_mendes.backend.entity.Saler;
import com.auto_mendes.backend.mapper.EmployeeMapper;

@Component
public class EmployeeMapperImpl implements EmployeeMapper {
	public Manager toManager(EmployeeRequestDTO request) {
		Manager manager = new Manager(null, request.name(), request.email(), request.registration(), request.phone(),
				request.birthDate());

		return manager;
	}

	public AssistantManager toAssistantManager(EmployeeRequestDTO request) {
		AssistantManager assistantManager = new AssistantManager(null, request.name(), request.email(), request.registration(), request.phone(),
				request.birthDate());
		
		return assistantManager;
	}

	public Saler toSaler(EmployeeRequestDTO request) {
		Saler saler = new Saler(null, request.name(), request.email(), request.registration(), request.phone(),
				request.birthDate(), request.commission(), null);
		
		return saler;
	}

	public EmployeeResponseDTO toEmployeeResponseDTO(Manager manager) {
		EmployeeResponseDTO response = new EmployeeResponseDTO(manager.getId(), manager.getName(), manager.getEmail(), manager.getRegistration(),
				manager.getPhone(), manager.getBirthDate(), null);
		
		return response;
	}

	public EmployeeResponseDTO toEmployeeResponseDTO(AssistantManager assistantManager) {
		EmployeeResponseDTO response = new EmployeeResponseDTO(assistantManager.getId(), assistantManager.getName(), assistantManager.getEmail(), assistantManager.getRegistration(),
				assistantManager.getPhone(), assistantManager.getBirthDate(), null);
		
		return response;
	}

	public EmployeeResponseDTO toEmployeeResponseDTO(Saler saler) {
		EmployeeResponseDTO response = new EmployeeResponseDTO(saler.getId(), saler.getName(), saler.getEmail(), saler.getRegistration(),
				saler.getPhone(), saler.getBirthDate(), saler.getCommission());
		
		return response;
	}
}
