package com.auto_mendes.backend.mapper;

import com.auto_mendes.backend.dto.request.AssistantManagerRequestDTO;
import com.auto_mendes.backend.dto.request.EmployeeRequestDTO;
import com.auto_mendes.backend.dto.request.ManagerRequestDTO;
import com.auto_mendes.backend.dto.request.SalerRequestDTO;
import com.auto_mendes.backend.dto.response.AssistantManagerResponseDTO;
import com.auto_mendes.backend.dto.response.EmployeeResponseDTO;
import com.auto_mendes.backend.dto.response.ManagerResponseDTO;
import com.auto_mendes.backend.dto.response.SalerResponseDTO;
import com.auto_mendes.backend.entity.AssistantManager;
import com.auto_mendes.backend.entity.Manager;
import com.auto_mendes.backend.entity.Saler;

public class EmployeeMapper {
	//vehlo codigo.
	
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
	
	//novo codigo.
	
	public static Manager toManager(ManagerRequestDTO dto) {
		return new Manager(null, dto.name(), dto.email(), dto.matriculation(), dto.phone(), dto.birthDate());
	}

	public static AssistantManager toAssistantManager(AssistantManagerRequestDTO dto) {
		return new AssistantManager(null, dto.name(), dto.email(), dto.matriculation(), dto.phone(), dto.birthDate());
	}

	public static Saler toSaler(SalerRequestDTO dto) {
		return new Saler(null, dto.name(), dto.email(), dto.matriculation(), dto.phone(), dto.birthDate(),
				dto.commission());
	}
	
	// velho codigo.

	public static EmployeeResponseDTO toEmployeeResponseDTO(Manager entity) {
		return new EmployeeResponseDTO(entity.getId(), entity.getName(), entity.getEmail(), entity.getMatriculation(),
				entity.getPhone(), entity.getBirthDate(), null);
	}

	public static EmployeeResponseDTO toEmployeeResponseDTO(AssistantManager entity) {
		return new EmployeeResponseDTO(entity.getId(), entity.getName(), entity.getEmail(), entity.getMatriculation(),
				entity.getPhone(), entity.getBirthDate(), null);
	}

	public static EmployeeResponseDTO toEmployeeResponseDTO(Saler entity) {
		return new EmployeeResponseDTO(entity.getId(), entity.getName(), entity.getEmail(), entity.getMatriculation(),
				entity.getPhone(), entity.getBirthDate(), entity.getCommission());
	}
	
	// novo codigo.
	
	public static ManagerResponseDTO toManagerResponseDTO(Manager entity) {
		return new ManagerResponseDTO(entity.getId(), entity.getName(), entity.getEmail(), entity.getMatriculation(),
				entity.getPhone(), entity.getBirthDate());
	}

	public static AssistantManagerResponseDTO toAssistantManagerResponseDTO(AssistantManager entity) {
		return new AssistantManagerResponseDTO(entity.getId(), entity.getName(), entity.getEmail(), entity.getMatriculation(),
				entity.getPhone(), entity.getBirthDate());
	}

	public static SalerResponseDTO toSalerResponseDTO(Saler entity) {
		return new SalerResponseDTO(entity.getId(), entity.getName(), entity.getEmail(), entity.getMatriculation(),
				entity.getPhone(), entity.getBirthDate(), entity.getCommission());
	}
}
