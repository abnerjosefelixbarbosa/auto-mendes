package com.auto_mendes.backend.mapper;

import org.springframework.stereotype.Component;

import com.auto_mendes.backend.dto.EmployeeRequestDTO;
import com.auto_mendes.backend.dto.EmployeeResponseDTO;
import com.auto_mendes.backend.model.Employee;

@Component
public class EmployeeMapper implements IEmployeeMapper {
	public Employee toEntity(EmployeeRequestDTO dto) {
		Employee employee = new Employee();
		employee.setBirthDate(dto.getBirthDate());
		employee.setEmail(dto.getEmail());
		employee.setEmployeeType(dto.getEmployeeType());
		employee.setName(dto.getName());
		employee.setPhone(dto.getPhone());
		employee.setRegistration(dto.getRegistration());
		employee.setCommission(dto.getCommission());
		
		return employee;
	}

	public EmployeeResponseDTO toDTO(Employee employee) {
		EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
		employeeResponseDTO.setBirthDate(employee.getBirthDate());
		employeeResponseDTO.setCommission(employee.getCommission());
		employeeResponseDTO.setEmail(employee.getEmail());
		employeeResponseDTO.setEmployeeType(employee.getEmployeeType());
		employeeResponseDTO.setId(employee.getId());
		employeeResponseDTO.setName(employee.getName());
		employeeResponseDTO.setPhone(employee.getPhone());
		employeeResponseDTO.setRegistration(employee.getRegistration());
		
		return employeeResponseDTO;
	}
}