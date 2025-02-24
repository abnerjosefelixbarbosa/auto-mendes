package com.org.auto_mendes_back_end_spring_boot_java.dtos.requests;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.br.CPF;

import com.org.auto_mendes_back_end_spring_boot_java.enums.EmployeeType;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "DTO de requisição do funcionário")
@Data
public class EmployeeRequestDTO {
	@Schema(description = "Nome do funcionario")
	@NotNull(message = "Nome deve ser obrigatório")
	@NotEmpty(message = "Nome deve ser obrigatório")
	@Size(message = "Nome deve ter até 100 caracteres", max = 100)
	private String name;
	@Schema(description = "CPF do funcionario")
	@NotNull(message = "CPF deve ser obrigatório")
	@NotEmpty(message = "CPF deve ser obrigatório")
	@Size(message = "CPF deve ter 14 caracteres", max = 14, min = 14)
	@CPF(message = "CPF deve ser válido")
    private String cpf;
	@Schema(description = "Email do funcionario")
    @NotNull(message = "Email deve ser obrigatório")
	@NotEmpty(message = "Email deve ser obrigatório")
	@Size(message = "Emial deve ter até 50 caracteres", max = 50)
	@Email(message = "Email deve ser válido")
    private String email;
	@Schema(description = "Telefone do funcionario")
    @NotNull(message = "Telefone deve ser obrigatório")
	@NotEmpty(message = "Telefone deve ser obrigatório")
	@Size(message = "Telefone deve ter de 10 até 20 caracteres", max = 20, min = 10)
    private String telephone;
	@Schema(description = "Salário do funcionario")
    @NotNull(message = "Salário deve ser obrigatório")
    private BigDecimal salary;
	@Schema(description = "Matrícula do funcionario")
    @NotNull(message = "Matrícula deve ser obrigatório")
	@NotEmpty(message = "Matrícula deve ser obrigatório")
	@Pattern(regexp = "^\\d{10}$", message = "Matrícula deve ter 10 caracteres numéricos")
    private String matriculation;
	@Schema(description = "Comissão do funcionario")
    private BigDecimal commission;
    private EmployeeType employeeType;
}