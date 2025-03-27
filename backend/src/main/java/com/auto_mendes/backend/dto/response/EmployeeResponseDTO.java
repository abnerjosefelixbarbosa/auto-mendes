package com.auto_mendes.backend.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.auto_mendes.backend.entity.Manager;

public record EmployeeResponseDTO(
		String id,
		String name,
		String email,
		String registration, 
		String phone,
		LocalDate birthDate,
		BigDecimal commission
) {
	public EmployeeResponseDTO(Manager manager) {
		this(manager.getId(), manager.getName(), manager.getEmail(), manager.getRegistration(), manager.getPhone(),
				manager.getBirthDate(), null);
	}
}