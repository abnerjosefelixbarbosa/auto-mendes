package com.org.auto_mendes_back_end_java.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import com.org.auto_mendes_back_end_java.entity.EmployeeType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record RegisterEmployeeRequest(
		@NotEmpty
		@NotNull
		String name,
		@NotNull
		@Enumerated(EnumType.STRING)
		EmployeeType employeeType,
		@NotNull
		LocalDate birthDate,
		@NotEmpty
		@NotNull
		@CPF
		String cpf,
		@NotEmpty
		@NotNull
		String rg,
		@NotEmpty
		@NotNull
		@Email
		String email,
		@NotEmpty
		@NotNull
		String contact
) {}