package com.auto_mendes.backend.mapper.impl;

import org.springframework.stereotype.Component;

import com.auto_mendes.backend.mapper.EmployeeMapper;
import com.auto_mendes.backend.model.dto.request.EmployeeRequestDTO;
import com.auto_mendes.backend.model.dto.response.EmployeeResponseDTO;
import com.auto_mendes.backend.model.entity.AssistantManager;
import com.auto_mendes.backend.model.entity.Manager;
import com.auto_mendes.backend.model.entity.Saler;

@Component
public class EmployeeMapperImpl implements EmployeeMapper {
	public Manager toManager(EmployeeRequestDTO dto) {
		return new Manager(null, dto.name(), dto.email(), dto.matriculation(), dto.phone(), dto.birthDate());
	}

	public AssistantManager toAssistantManager(EmployeeRequestDTO dto) {
		return new AssistantManager(null, dto.name(), dto.email(), dto.matriculation(), dto.phone(), dto.birthDate());
	}

	public Saler toSaler(EmployeeRequestDTO dto) {
		return new Saler(null, dto.name(), dto.email(), dto.matriculation(), dto.phone(), dto.birthDate(),
				dto.commission());
	}

	public EmployeeResponseDTO toEmployeeResponseDTO(Manager manager) {
		return new EmployeeResponseDTO(manager.getId(), manager.getName(), manager.getEmail(),
				manager.getMatriculation(), manager.getPhone(), manager.getBirthDate(), null);
	}

	public EmployeeResponseDTO toEmployeeResponseDTO(AssistantManager assistantManager) {
		return new EmployeeResponseDTO(assistantManager.getId(), assistantManager.getName(),
				assistantManager.getEmail(), assistantManager.getMatriculation(), assistantManager.getPhone(),
				assistantManager.getBirthDate(), null);
	}

	public EmployeeResponseDTO toEmployeeResponseDTO(Saler saler) {
		return new EmployeeResponseDTO(saler.getId(), saler.getName(), saler.getEmail(), saler.getMatriculation(),
				saler.getPhone(), saler.getBirthDate(), saler.getCommission());
	}
}
