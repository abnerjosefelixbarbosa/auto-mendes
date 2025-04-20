package com.auto_mendes.backend.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public record SalerResponseDTO(
		String id,
		String name,
		String email,
		String matriculation, 
		String phone,
		LocalDate birthDate,
		BigDecimal commission
) {}