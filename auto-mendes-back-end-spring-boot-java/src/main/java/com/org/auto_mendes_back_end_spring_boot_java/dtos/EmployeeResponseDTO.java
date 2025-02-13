package com.org.auto_mendes_back_end_spring_boot_java.dtos;

import java.math.BigDecimal;

import com.org.auto_mendes_back_end_spring_boot_java.entities.Employee;

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

	public EmployeeResponseDTO(Employee employee) {
		this.id = employee.getId();
		this.name = employee.getName();
		this.cpf = employee.getCpf();
		this.email = employee.getEmail();
		this.telephone = employee.getTelephone();
		this.salary = employee.getSalary();
		this.matriculation = employee.getMatriculation();
	}
}