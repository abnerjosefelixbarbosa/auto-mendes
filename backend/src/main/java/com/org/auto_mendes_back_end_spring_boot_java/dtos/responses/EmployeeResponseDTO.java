package com.org.auto_mendes_back_end_spring_boot_java.dtos.responses;

import java.math.BigDecimal;

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
}