package com.auto_mendes.backend.mapper.impl;

import org.springframework.stereotype.Component;

import com.auto_mendes.backend.dto.EmployeeRequestDTO;
import com.auto_mendes.backend.dto.EmployeeResponseDTO;
import com.auto_mendes.backend.entity.AssistantManager;
import com.auto_mendes.backend.entity.Manager;
import com.auto_mendes.backend.entity.Saler;
import com.auto_mendes.backend.mapper.EmployeeMapper;

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

	public EmployeeResponseDTO toEmployeeResponseDTO(Manager entity) {
		return new EmployeeResponseDTO(entity.getId(), entity.getName(), entity.getEmail(), entity.getMatriculation(),
				entity.getPhone(), entity.getBirthDate(), null);
	}

	public EmployeeResponseDTO toEmployeeResponseDTO(AssistantManager entity) {
		return new EmployeeResponseDTO(entity.getId(), entity.getName(), entity.getEmail(), entity.getMatriculation(),
				entity.getPhone(), entity.getBirthDate(), null);
	}

	public EmployeeResponseDTO toEmployeeResponseDTO(Saler entity) {
		return new EmployeeResponseDTO(entity.getId(), entity.getName(), entity.getEmail(), entity.getMatriculation(),
				entity.getPhone(), entity.getBirthDate(), entity.getCommission());
	}
}
