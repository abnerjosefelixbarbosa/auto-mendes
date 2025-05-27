package com.auto_mendes.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.auto_mendes.backend.enums.EmployeeType;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmployeeRequestDTO {
	@NotNull(message = "Nome não deve ser nulo.")
	@NotEmpty(message = "Nome não deve ser vazio.")
	@Size(max = 100, message = "Nome deve ter no máximo 100 caracteres.")
	private String name;
	@NotNull(message = "Email não deve ser nulo.")
	@NotEmpty(message = "Email não deve ser vazio.")
	@Size(max = 100, message = "Email deve ter no máximo 100 caracteres.")
	private String email;
	@NotNull(message = "Matrícula não deve ser nula.")
	@Pattern(message = "Matrícula deve ter 10 caracteres numéricos.", regexp = "^\\d{10}$")
	private String registration;
	@NotNull(message = "Telefone não deve ser nulo.")
	@NotEmpty(message = "Telefone não deve ser vazio.")
	@Size(max = 30, message = "Telefone deve ter no máximo 30 caracteres.")
	private String phone;
	@NotNull(message = "Data de nascimento não deve ser nula.")
	@Past(message = "Data de nascimento deve ser passada.")
	private LocalDate birthDate;
	private BigDecimal commission;
	@NotNull(message = "Tipo de funcionário não deve ser nulo.")
	private EmployeeType employeeType;
}