package com.org.auto_mendes_back_end_spring_boot_java.dtos;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.br.CPF;

import com.org.auto_mendes_back_end_spring_boot_java.enums.EmployeeType;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequestDTO {
	@NotNull(message = "nome deve ser obrigatório")
	@NotEmpty(message = "nome deve ser obrigatório")
	@Size(message = "nome deve ter até 100 caracteres", max = 100)
	private String name;
	@NotNull(message = "cpf deve ser obrigatório")
	@NotEmpty(message = "cpf deve ser obrigatório")
	@Size(message = "cpf deve ter 14 caracteres", max = 14, min = 14)
	@CPF(message = "cpf deve ser válido")
    private String cpf;
    @NotNull(message = "email deve ser obrigatório")
	@NotEmpty(message = "email deve ser obrigatório")
	@Size(message = "emial deve ter até 50 caracteres", max = 50)
	@Email(message = "email deve ser válido")
    private String email;
    @NotNull(message = "telefone deve ser obrigatório")
	@NotEmpty(message = "telefone deve ser obrigatório")
	@Size(message = "telefone deve ter de 10 até 20 caracteres", max = 20, min = 10)
    private String telephone;
    @NotNull(message = "salário deve ser obrigatório")
    private BigDecimal salary;
    @NotNull(message = "matrícula deve ser obrigatório")
	@NotEmpty(message = "matrícula deve ser obrigatório")
	@Pattern(regexp = "^\\d{10}$", message = "matrícula deve ter 10 caracteres numéricos")
    private String matriculation;
    private BigDecimal commission;
    private EmployeeType employeeType;
}