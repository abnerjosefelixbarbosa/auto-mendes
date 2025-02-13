package com.org.auto_mendes_back_end_spring_boot_java.dtos;

import java.math.BigDecimal;

import com.org.auto_mendes_back_end_spring_boot_java.entities.Saler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSalerResponseDTO {
	private String id;
	private String name;
	private String cpf;
	private String email;
	private String telephone;
	private BigDecimal salary;
	private String matriculation;
	private BigDecimal commission;
	
	public EmployeeSalerResponseDTO(Saler saler) {
		this.id = saler.getId();
		this.name = saler.getName();
		this.cpf = saler.getCpf();
		this.email = saler.getEmail();
		this.telephone = saler.getTelephone();
		this.salary = saler.getSalary();
		this.matriculation = saler.getMatriculation();
		this.commission = saler.getCommission();
	}
	
	
}