package com.auto_mendes.backend.dto.response;

import java.time.LocalDate;

public record AssistantManagerResponseDTO(
		String id,
		String name,
		String email,
		String matriculation, 
		String phone,
		LocalDate birthDate
) {}