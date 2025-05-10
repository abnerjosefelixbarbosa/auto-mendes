package com.auto_mendes.backend.mapper;

import com.auto_mendes.backend.dto.request.EmployeeRequestDTO;
import com.auto_mendes.backend.dto.response.EmployeeResponseDTO;
import com.auto_mendes.backend.enums.EmployeeType;
import com.auto_mendes.backend.model.AssistantManager;
import com.auto_mendes.backend.model.Manager;
import com.auto_mendes.backend.model.Saler;

public class EmployeeMapper {
	public static Manager toManager(EmployeeRequestDTO employeeRequestDTO) {
		return new Manager(null, employeeRequestDTO.getName(), employeeRequestDTO.getEmail(),
				employeeRequestDTO.getMatriculation(), employeeRequestDTO.getPhone(), employeeRequestDTO.getBirthDate(),
				employeeRequestDTO.getEmployeeType());
	}

	public static AssistantManager toAssistantManager(EmployeeRequestDTO employeeRequestDTO) {
		return new AssistantManager(null, employeeRequestDTO.getName(), employeeRequestDTO.getEmail(),
				employeeRequestDTO.getMatriculation(), employeeRequestDTO.getPhone(), employeeRequestDTO.getBirthDate(),
				employeeRequestDTO.getEmployeeType());
	}

	public static Saler toSaler(EmployeeRequestDTO employeeRequestDTO) {
		return new Saler(null, employeeRequestDTO.getName(), employeeRequestDTO.getEmail(),
				employeeRequestDTO.getMatriculation(), employeeRequestDTO.getPhone(), employeeRequestDTO.getBirthDate(),
				employeeRequestDTO.getEmployeeType(), employeeRequestDTO.getCommission());
	}

	public static EmployeeResponseDTO toEmployeeResponseDTO(Manager manager) {
		return new EmployeeResponseDTO(manager.getId(), manager.getName(), manager.getEmail(),
				manager.getMatriculation(), manager.getPhone(), manager.getBirthDate(), EmployeeType.MANAGER, null);
	}

	public static EmployeeResponseDTO toEmployeeResponseDTO(AssistantManager assistantManager) {
		return new EmployeeResponseDTO(assistantManager.getId(), assistantManager.getName(),
				assistantManager.getEmail(), assistantManager.getMatriculation(), assistantManager.getPhone(),
				assistantManager.getBirthDate(), EmployeeType.ASSISTANT_MANAGER, null);
	}

	public static EmployeeResponseDTO toEmployeeResponseDTO(Saler saler) {
		return new EmployeeResponseDTO(saler.getId(), saler.getName(), saler.getEmail(), saler.getMatriculation(),
				saler.getPhone(), saler.getBirthDate(), EmployeeType.SALER, saler.getCommission());
	}
}
