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

	public Manager toManager(String id, Manager entity) {
		return new Manager(id, entity.getName(), entity.getEmail(), entity.getMatriculation(),
				entity.getPhone(), entity.getBirthDate());
	}

	public AssistantManager toAssistantManager(String id, AssistantManager entity) {
		return new AssistantManager(id, entity.getName(), entity.getEmail(), entity.getMatriculation(),
				entity.getPhone(), entity.getBirthDate());
	}

	public Saler toSaler(String id,  Saler entity) {
		return new Saler(id, entity.getName(), entity.getEmail(), entity.getMatriculation(),
				entity.getPhone(), entity.getBirthDate(), entity.getCommission());
	}
}
