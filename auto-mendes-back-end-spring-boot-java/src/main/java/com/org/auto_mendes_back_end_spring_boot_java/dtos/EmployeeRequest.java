package com.org.auto_mendes_back_end_spring_boot_java.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

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
public class EmployeeRequest {
	@NotEmpty(message = "Nome deve ser obrigatório")
	@NotNull(message = "Nome deve ser obrigatório")
	@Size(max = 100, message = "Nome deve ser até 100 caracteres")
	private String name;
	@Size(max = 20, message = "CPF deve ser até 20 caracteres")
	@CPF(message = "CPF deve ser valido")
	private String cpf;
	@NotNull(message = "Birth date deve ser obrigatório")
	private LocalDate birthDate;	
	@NotNull(message = "Email deve ser obrigatório")
	@NotEmpty(message = "Email deve ser obrigatório")
	@Email(message = "Email deve ser valido")
	private String email;
	@NotNull(message = "Contato deve ser obrigatório")
	@NotEmpty(message = "Contato deve ser obrigatório")
	@Size(max = 20, message = "Contato deve ser até 20 caracteres")
	private String contact;
	@Pattern(regexp = "\\d{10}", message = "Matrícula deve ser com 10 números")
	private String matriculation;
	private BigDecimal commission;
	private EmployeeType employeeType;
}
