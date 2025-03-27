package com.auto_mendes.backend.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.auto_mendes.backend.enums.EmployeeType;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record EmployeeRequestDTO(
		@NotEmpty(message = "Nome não deve ser vazio.")
		@NotNull(message = "Nome não deve ser nulo.")
		@Size(max = 100, message = "Nome não deve ter mais de 100 caracteres.")
		String name,
		@NotEmpty(message = "Email não deve ser vazio.")
		@NotNull(message = "Email não deve ser nulo.")
		@Size(max = 100, message = "Email não deve ter mais de 100 caracteres.")
		@Email(message = "Email deve ser valido.")
		String email,
		@NotEmpty(message = "Matricula não deve ser vazio.")
		@NotNull(message = "Matricula não deve ser nulo.")
		@Pattern(regexp = "^\\d{10}$", message = "Matricula deve ter 10 numeros")
		String registration,
		@NotEmpty(message = "Telefone não deve ser vazio.")
		@NotNull(message = "Telefone não deve ser nulo.")
		@Size(max = 30, message = "Telefone não deve ter mais de 30 caracteres.")
		String phone,
		@NotNull(message = "Data de nascimento não deve ser nulo.")
		LocalDate birthDate,
		@NotNull(message = "Tipo de funcionário não deve ser nulo.")
		EmployeeType employeeType,
		BigDecimal commission
) {}