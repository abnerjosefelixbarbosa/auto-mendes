package com.org.auto_mendes_back_end_java.model.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import com.org.auto_mendes_back_end_java.model.entity.EmployeeType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record EmployeeRegistrationRequest(
		@NotEmpty(message = "Name empty")
		@NotNull(message = "Name null")
		String name,
		@NotNull(message = "Employee type null")
		@Enumerated(EnumType.STRING)
		EmployeeType employeeType,
		@NotNull(message = "Birth date null")
		@Past(message = "Birth date present or future")
		LocalDate birthDate,
		@NotEmpty(message = "CPF empty")
		@NotNull(message = "CPF null")
		@CPF(message = "CPF invalid")
		@Pattern(regexp = "^\\d+$", message = "CPF period")
		String cpf,
		@NotEmpty(message = "RG empty")
		@NotNull(message = "RG null")
		@Pattern(regexp = "^\\d+$", message = "RG period")
		String rg,
		@NotEmpty(message = "Email empty")
		@NotNull(message = "Email null")
		@Email(message = "Email invalid")
		String email,
		@NotEmpty(message = "Contact empty")
		@NotNull(message = "Contact null")
		@Size(min = 15, max = 15, message = "Contact size 15")
		String contact
) {}