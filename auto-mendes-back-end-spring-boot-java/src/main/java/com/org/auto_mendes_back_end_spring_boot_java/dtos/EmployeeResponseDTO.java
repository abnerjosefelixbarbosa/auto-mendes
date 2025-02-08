package com.org.auto_mendes_back_end_spring_boot_java.dtos;

import java.math.BigDecimal;

import com.org.auto_mendes_back_end_spring_boot_java.entities.Employee;
import com.org.auto_mendes_back_end_spring_boot_java.enums.EmployeeType;

public record EmployeeResponseDTO(
		String id,
		String name,
		String cpf,
		String email,
		String telephone,
		BigDecimal salary,
		String matriculation,
		BigDecimal commission,
		EmployeeType employeeType
) {
	public EmployeeResponseDTO(Employee employee) {
		this(
				employee.getId(),
				employee.getName(),
				employee.getCpf(),
				employee.getEmail(),
				employee.getTelephone(),
				employee.getSalary(),
				employee.getMatriculation(),
				employee.getCommission(),
				employee.getEmployeeType()
		);
	}
}