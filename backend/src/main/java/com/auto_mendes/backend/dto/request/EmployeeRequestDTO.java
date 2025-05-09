package com.auto_mendes.backend.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.auto_mendes.backend.enums.EmployeeType;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequestDTO {
	@NotEmpty(message = "Nome vázio.")
	@NotNull(message = "Nome nulo.")
	@Size(max = 100, message = "Nome com no máximo 100 caracteres.")
	private String name;
	@NotEmpty(message = "Email vázio.")
	@NotNull(message = "Email nulo.")
	@Size(max = 100, message = "Email com no máximo 100 caracteres.")
	@Email(message = "Email invalido.")
	private String email;
	@NotEmpty(message = "Matrícula vázio.")
	@NotNull(message = "Matrícula nulo.")
	@Pattern(regexp = "^\\d{10}$", message = "Matrícula com 10 números.")
	private String matriculation;
	@NotEmpty(message = "Telefone vazio.")
	@NotNull(message = "Telefone nulo.")
	@Size(max = 30, message = "Telefone com no máximo 30 caracteres.")
	private String phone;
	@Past(message = "Data de nascimento presente ou futura.")
	@NotNull(message = "Data de nascimento nulo.")
	private LocalDate birthDate;
	@NotNull(message = "Tipo de funcionário nulo.")
	private EmployeeType employeeType;
	BigDecimal commission;
}