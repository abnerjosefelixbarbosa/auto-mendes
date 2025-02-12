package com.org.auto_mendes_back_end_spring_boot_java.dtos;

import java.math.BigDecimal;

import com.org.auto_mendes_back_end_spring_boot_java.entities.Employee;
import com.org.auto_mendes_back_end_spring_boot_java.enums.EmployeeType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDTO {
	private String id;
	private String name;
	private String cpf;
	private String email;
	private String telephone;
	private BigDecimal salary;
	private String matriculation;
	private EmployeeType employeeType;

	public EmployeeResponseDTO(Employee employee, BigDecimal commission) {
		this(employee.getId(), employee.getName(), employee.getCpf(), employee.getEmail(), employee.getTelephone(),
				employee.getSalary(), employee.getMatriculation(), commission);
	}

	public EmployeeResponseDTO(Object[] obj) {
		this((String) obj[0], (String) obj[1], (String) obj[2],
				(String) obj[3], (String) obj[4], (BigDecimal) obj[5], (String) obj[6], null);
	}
}