package com.auto_mendes.backend.mapper;

import org.springframework.stereotype.Component;

import com.auto_mendes.backend.dto.EmployeeRequestDTO;
import com.auto_mendes.backend.dto.EmployeeResponseDTO;
import com.auto_mendes.backend.enums.EmployeeType;
import com.auto_mendes.backend.model.Employee;
import com.auto_mendes.backend.model.Manager;
import com.auto_mendes.backend.model.Saler;
import com.auto_mendes.backend.model.Submanager;

@Component
public class EmployeeMapper implements IEmployeeMapper {
	public Employee toEntity(EmployeeRequestDTO dto) {
		Employee employee = new Employee();
		employee.setBirthDate(dto.getBirthDate());
		employee.setEmail(dto.getEmail());
		employee.setName(dto.getName());
		employee.setPhone(dto.getPhone());
		employee.setMatriculation(dto.getMatriculation());

		return employee;
	}
	
	public Manager toManager(EmployeeRequestDTO dto) {
		Manager employee = new Manager();
		employee.setBirthDate(dto.getBirthDate());
		employee.setEmail(dto.getEmail());
		employee.setName(dto.getName());
		employee.setPhone(dto.getPhone());
		employee.setMatriculation(dto.getMatriculation());

		return employee;
	}
	
	public Submanager toSubmanager(EmployeeRequestDTO dto) {
		Submanager employee = new Submanager();
		employee.setBirthDate(dto.getBirthDate());
		employee.setEmail(dto.getEmail());
		employee.setName(dto.getName());
		employee.setPhone(dto.getPhone());
		employee.setMatriculation(dto.getMatriculation());

		return employee;
	}
	
	public Saler toSaler(EmployeeRequestDTO dto) {
		Saler employee = new Saler();
		employee.setBirthDate(dto.getBirthDate());
		employee.setEmail(dto.getEmail());
		employee.setName(dto.getName());
		employee.setPhone(dto.getPhone());
		employee.setMatriculation(dto.getMatriculation());
		employee.setCommission(dto.getCommission());

		return employee;
	}

	public EmployeeResponseDTO toDTO(Employee employee) {
		EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
		employeeResponseDTO.setBirthDate(employee.getBirthDate());
		employeeResponseDTO.setEmail(employee.getEmail());
		employeeResponseDTO.setId(employee.getId());
		employeeResponseDTO.setName(employee.getName());
		employeeResponseDTO.setPhone(employee.getPhone());
		employeeResponseDTO.setMatriculation(employee.getMatriculation());

		return employeeResponseDTO;
	}
	
	public EmployeeResponseDTO toDTO(Manager manager) {
		EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
		employeeResponseDTO.setBirthDate(manager.getBirthDate());
		employeeResponseDTO.setEmail(manager.getEmail());
		employeeResponseDTO.setId(manager.getId());
		employeeResponseDTO.setName(manager.getName());
		employeeResponseDTO.setPhone(manager.getPhone());
		employeeResponseDTO.setMatriculation(manager.getMatriculation());
		employeeResponseDTO.setEmployeeType(EmployeeType.MANAGER);

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
		employeeResponseDTO.setEmployeeType(EmployeeType.SUBMANAGER);

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
		employeeResponseDTO.setEmployeeType(EmployeeType.SALER);

		return employeeResponseDTO;
	}
}