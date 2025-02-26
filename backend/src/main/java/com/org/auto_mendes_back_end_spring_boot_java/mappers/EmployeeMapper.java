package com.org.auto_mendes_back_end_spring_boot_java.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.github.f4b6a3.ulid.UlidCreator;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.EmployeeRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.EmployeeResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.DeputyManager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Manager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Saler;

@Component
public class EmployeeMapper {
	public Manager toManager(EmployeeRequestDTO dto) {
		Manager manager = new Manager();
		manager.setId(UlidCreator.getUlid().toString());
		
		BeanUtils.copyProperties(dto, manager);
		
		return manager;
	}
	
	public DeputyManager toDeputyManager(EmployeeRequestDTO dto) {
		DeputyManager deputyManager = new DeputyManager();
		deputyManager.setId(UlidCreator.getUlid().toString());
		
		BeanUtils.copyProperties(dto, deputyManager);
		
		return null;
	}

	public Saler toSaler(EmployeeRequestDTO dto) {
		Saler saler = new Saler();
		saler.setId(UlidCreator.getUlid().toString());
		
		BeanUtils.copyProperties(dto, saler);
		
		return saler;
	}

	public EmployeeResponseDTO toEmployeeResponseDTO(Manager manager) {
		EmployeeResponseDTO dto = new EmployeeResponseDTO();
		
		BeanUtils.copyProperties(manager, dto);
		
		return dto;
	}

	public EmployeeResponseDTO toEmployeeResponseDTO(DeputyManager deputyManager) {
		EmployeeResponseDTO dto = new EmployeeResponseDTO();
		
		BeanUtils.copyProperties(deputyManager, dto);
		
		return dto;
	}

	public EmployeeResponseDTO toEmployeeResponseDTO(Saler saler) {
		EmployeeResponseDTO dto = new EmployeeResponseDTO();
		
		BeanUtils.copyProperties(saler, dto);
		
		return dto;
	}
}