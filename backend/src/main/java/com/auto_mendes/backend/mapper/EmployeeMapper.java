package com.auto_mendes.backend.mapper;

import com.auto_mendes.backend.dto.request.EmployeeRequestDTO;
import com.auto_mendes.backend.dto.response.EmployeeResponseDTO;
import com.auto_mendes.backend.enums.EmployeeType;
import com.auto_mendes.backend.model.AssistantManager;
import com.auto_mendes.backend.model.Manager;
import com.auto_mendes.backend.model.Saler;

public class EmployeeMapper {
	public static Manager toManager(EmployeeRequestDTO data) {
		return new Manager(null, data.getName(), data.getEmail(), data.getMatriculation(), data.getPhone(),
				data.getBirthDate(), data.getEmployeeType());
	}

	public static AssistantManager toAssistantManager(EmployeeRequestDTO data) {
		return new AssistantManager(null, data.getName(), data.getEmail(), data.getMatriculation(), data.getPhone(),
				data.getBirthDate(), data.getEmployeeType());
	}

	public static Saler toSaler(EmployeeRequestDTO dto) {
		return new Saler(null, dto.getName(), dto.getEmail(), dto.getMatriculation(), dto.getPhone(), dto.getBirthDate(),
				dto.getEmployeeType(), dto.getCommission());
	}

	public static EmployeeResponseDTO toEmployeeResponseDTO(Manager data) {
		return new EmployeeResponseDTO(data.getId(), data.getName(), data.getEmail(), data.getMatriculation(),
				data.getPhone(), data.getBirthDate(), EmployeeType.MANAGER, null);
	}

	public static EmployeeResponseDTO toEmployeeResponseDTO(AssistantManager entity) {
		return new EmployeeResponseDTO(entity.getId(), entity.getName(), entity.getEmail(), entity.getMatriculation(),
				entity.getPhone(), entity.getBirthDate(), EmployeeType.ASSISTANT_MANAGER, null);
	}

	public static EmployeeResponseDTO toEmployeeResponseDTO(Saler data) {
		return new EmployeeResponseDTO(data.getId(), data.getName(), data.getEmail(), data.getMatriculation(),
				data.getPhone(), data.getBirthDate(), EmployeeType.SALER, data.getCommission());
	}
}
