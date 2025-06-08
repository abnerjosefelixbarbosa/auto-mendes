package com.auto_mendes.backend.mapper;

import org.springframework.stereotype.Component;

import com.auto_mendes.backend.dto.EmployeeRequestDTO;
import com.auto_mendes.backend.dto.EmployeeResponseDTO;
import com.auto_mendes.backend.dto.EmployeeResponseListDTO;
import com.auto_mendes.backend.model.Manager;
import com.auto_mendes.backend.model.Saler;
import com.auto_mendes.backend.model.Submanager;

@Component
public class EmployeeMapper implements IEmployeeMapper {
	public Manager toManager(EmployeeRequestDTO dto) {
		Manager manager = new Manager();
		manager.setBirthDate(dto.getBirthDate());
		manager.setEmail(dto.getEmail());
		manager.setName(dto.getName());
		manager.setPhone(dto.getPhone());
		manager.setMatriculation(dto.getMatriculation());
		manager.setEmployeeType(dto.getEmployeeType());

		return manager;
	}
	
	public Submanager toSubmanager(EmployeeRequestDTO dto) {
		Submanager submanager = new Submanager();
		submanager.setBirthDate(dto.getBirthDate());
		submanager.setEmail(dto.getEmail());
		submanager.setName(dto.getName());
		submanager.setPhone(dto.getPhone());
		submanager.setMatriculation(dto.getMatriculation());
		submanager.setEmployeeType(dto.getEmployeeType());

		return submanager;
	}
	
	public Saler toSaler(EmployeeRequestDTO dto) {
		Saler saler = new Saler();
		saler.setBirthDate(dto.getBirthDate());
		saler.setEmail(dto.getEmail());
		saler.setName(dto.getName());
		saler.setPhone(dto.getPhone());
		saler.setMatriculation(dto.getMatriculation());
		saler.setCommission(dto.getCommission());
		saler.setEmployeeType(dto.getEmployeeType());

		return saler;
	}
	
	public EmployeeResponseDTO toDTO(Manager manager) {
		EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
		employeeResponseDTO.setBirthDate(manager.getBirthDate());
		employeeResponseDTO.setEmail(manager.getEmail());
		employeeResponseDTO.setId(manager.getId());
		employeeResponseDTO.setName(manager.getName());
		employeeResponseDTO.setPhone(manager.getPhone());
		employeeResponseDTO.setMatriculation(manager.getMatriculation());
		employeeResponseDTO.setEmployeeType(manager.getEmployeeType());

		return employeeResponseDTO;
	}
	
	public EmployeeResponseDTO toDTO(Submanager submanager) {
		EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
		employeeResponseDTO.setBirthDate(submanager.getBirthDate());
		employeeResponseDTO.setEmail(submanager.getEmail());
		employeeResponseDTO.setId(submanager.getId());
		employeeResponseDTO.setName(submanager.getName());
		employeeResponseDTO.setPhone(submanager.getPhone());
		employeeResponseDTO.setMatriculation(submanager.getMatriculation());
		employeeResponseDTO.setEmployeeType(submanager.getEmployeeType());

		return employeeResponseDTO;
	}
	
	public EmployeeResponseDTO toDTO(Saler saler) {
		EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
		employeeResponseDTO.setBirthDate(saler.getBirthDate());
		employeeResponseDTO.setCommission(saler.getCommission());
		employeeResponseDTO.setEmail(saler.getEmail());
		employeeResponseDTO.setId(saler.getId());
		employeeResponseDTO.setName(saler.getName());
		employeeResponseDTO.setPhone(saler.getPhone());
		employeeResponseDTO.setMatriculation(saler.getMatriculation());
		employeeResponseDTO.setEmployeeType(saler.getEmployeeType());

		return employeeResponseDTO;
	}

	public EmployeeResponseDTO toDTO(EmployeeResponseListDTO dto) {
		EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
		employeeResponseDTO.setId(dto.getId());
		employeeResponseDTO.setEmail(dto.getEmail());
		employeeResponseDTO.setName(dto.getName());
		employeeResponseDTO.setMatriculation(dto.getMatriculation());
		employeeResponseDTO.setPhone(dto.getPhone());
		//employeeResponseDTO.setBirthDate(dto.getBirthDate());
		//employeeResponseDTO.setEmployeeType(null);
		employeeResponseDTO.setCommission(dto.getCommission());
		
		return employeeResponseDTO;
	}
}