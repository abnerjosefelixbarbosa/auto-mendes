package com.auto_mendes.backend.model.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record BrandRequestDTO(
		@NotNull(message = "Nome deve ser obrigatório")
		@NotEmpty(message = "Nome deve ser obrigatório")
		@Size(max = 50, message = "Nome deve ter até 50 caracteres")
		String name
) {}