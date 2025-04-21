package com.auto_mendes.backend.mapper;

import com.auto_mendes.backend.dto.request.EmployeeRequestDTO;
import com.auto_mendes.backend.dto.response.EmployeeResponseDTO;
import com.auto_mendes.backend.entity.AssistantManager;
import com.auto_mendes.backend.entity.Manager;
import com.auto_mendes.backend.entity.Saler;
import com.auto_mendes.backend.enums.EmployeeType;

public class EmployeeMapper {
	public static Manager toManager(EmployeeRequestDTO dto) {
		return new Manager(null, dto.name(), dto.email(), dto.matriculation(), dto.phone(), dto.birthDate());
	}

	public static AssistantManager toAssistantManager(EmployeeRequestDTO dto) {
		return new AssistantManager(null, dto.name(), dto.email(), dto.matriculation(), dto.phone(), dto.birthDate());
	}

	public static Saler toSaler(EmployeeRequestDTO dto) {
		return new Saler(null, dto.name(), dto.email(), dto.matriculation(), dto.phone(), dto.birthDate(),
				dto.commission());
	}

	public static EmployeeResponseDTO toEmployeeResponseDTO(Manager entity) {
		return new EmployeeResponseDTO(entity.getId(), entity.getName(), entity.getEmail(), entity.getMatriculation(),
				entity.getPhone(), entity.getBirthDate(), EmployeeType.MANAGER, null);
	}

	public static EmployeeResponseDTO toEmployeeResponseDTO(AssistantManager entity) {
		return new EmployeeResponseDTO(entity.getId(), entity.getName(), entity.getEmail(), entity.getMatriculation(),
				entity.getPhone(), entity.getBirthDate(), EmployeeType.ASSISTANT_MANAGER, null);
	}

	public static EmployeeResponseDTO toEmployeeResponseDTO(Saler entity) {
		return new EmployeeResponseDTO(entity.getId(), entity.getName(), entity.getEmail(), entity.getMatriculation(),
				entity.getPhone(), entity.getBirthDate(), EmployeeType.SALER, entity.getCommission());
	}
}
