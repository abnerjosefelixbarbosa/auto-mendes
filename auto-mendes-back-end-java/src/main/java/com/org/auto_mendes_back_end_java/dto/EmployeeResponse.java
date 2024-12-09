package com.org.auto_mendes_back_end_java.dto;

import java.time.LocalDate;

import com.org.auto_mendes_back_end_java.entity.EmployeeType;

public record EmployeeResponse(
		String id,
		String name,
		EmployeeType employeeType,
		LocalDate birthDate,
		String cpf,
		String rg,
		String email,
		String contact
) {}