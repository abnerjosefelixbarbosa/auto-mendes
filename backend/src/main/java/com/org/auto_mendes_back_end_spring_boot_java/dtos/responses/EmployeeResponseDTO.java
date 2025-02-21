package com.org.auto_mendes_back_end_spring_boot_java.dtos.responses;

import java.math.BigDecimal;

import com.org.auto_mendes_back_end_spring_boot_java.entities.DeputyManager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Manager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Saler;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "DTO de resposta do funcionário")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDTO {
	@Schema(description = "ID do funcionario")
	private String id;
	@Schema(description = "Nome do funcionario")
	private String name;
	@Schema(description = "CPF do funcionario")
	private String cpf;
	@Schema(description = "Email do funcionario")
	private String email;
	@Schema(description = "Telefone do funcionario")
	private String telephone;
	@Schema(description = "Salário do funcionario")
	private BigDecimal salary;
	@Schema(description = "Matrícula do funcionario")
	private String matriculation;
	@Schema(description = "Comissão do funcionario")
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