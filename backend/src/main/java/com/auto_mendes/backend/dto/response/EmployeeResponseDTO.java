package com.auto_mendes.backend.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.auto_mendes.backend.enums.EmployeeType;

public record EmployeeResponseDTO(
		String id,
		String name,
		String email,
		String matriculation, 
		String phone,
		LocalDate birthDate,
		EmployeeType employeeType,
		BigDecimal commission
) {}