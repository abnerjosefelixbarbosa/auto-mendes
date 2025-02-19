package com.org.auto_mendes_back_end_spring_boot_java.dtos;

import java.math.BigDecimal;

import com.org.auto_mendes_back_end_spring_boot_java.entities.DeputyManager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Manager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Saler;

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
	private BigDecimal commission;
	
	public EmployeeResponseDTO(Manager manager) {
		this.id = manager.getId();
		this.name = manager.getName();
		this.cpf = manager.getCpf();
		this.email = manager.getEmail();
		this.telephone = manager.getTelephone();
		this.salary = manager.getSalary();
		this.matriculation = manager.getMatriculation();
	}

	public EmployeeResponseDTO(DeputyManager deputyManager) {
		this.id = deputyManager.getId();
		this.name = deputyManager.getName();
		this.cpf = deputyManager.getCpf();
		this.email = deputyManager.getEmail();
		this.telephone = deputyManager.getTelephone();
		this.salary = deputyManager.getSalary();
		this.matriculation = deputyManager.getMatriculation();
	}

	public EmployeeResponseDTO(Saler saler) {
		this.id = saler.getId();
		this.name = saler.getName();
		this.cpf = saler.getCpf();
		this.email = saler.getEmail();
		this.telephone = saler.getTelephone();
		this.salary = saler.getSalary();
		this.matriculation = saler.getMatriculation();
	}
}