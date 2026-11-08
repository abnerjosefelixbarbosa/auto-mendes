package com.concessionaria.backend.mapper;

import com.concessionaria.backend.dto.request.EmployeeRequestDTO;
import com.concessionaria.backend.dto.response.EmployeeResponseDTO;
import com.concessionaria.backend.entity.Employee;

public class EmployeeMapper {
	public static Employee toEmployee(EmployeeRequestDTO request) {
		Employee employee = new Employee(null, request.name(), request.matriculation(), request.email(),
				request.phone(), request.birthDate(), request.cpf(), request.salary(), request.commission(),
				request.employeeStatus(), request.employeeType(), null);

		return employee;
	}

	public static EmployeeResponseDTO toEmployeeResponseDTO(Employee employee) {
		EmployeeResponseDTO response = new EmployeeResponseDTO(employee.getId(), employee.getName(), employee.getMatriculation(),
				employee.getEmail(), employee.getPhone(), employee.getBirthDate(), employee.getCpf(),
				employee.getSalary(), employee.getCommission(), employee.getEmployeeStatus(),
				employee.getEmployeeType());
		
		return response;
	}
}