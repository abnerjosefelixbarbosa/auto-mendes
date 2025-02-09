package com.org.auto_mendes_back_end_spring_boot_java.dtos;

import java.math.BigDecimal;

import com.org.auto_mendes_back_end_spring_boot_java.enums.EmployeeType;

public record EmployeeResponseDTO(
		String id,
		String name,
		String cpf,
		String email,
		String telephone,
		BigDecimal salary,
		String matriculation,
		BigDecimal commission,
		EmployeeType employeeType
) {}