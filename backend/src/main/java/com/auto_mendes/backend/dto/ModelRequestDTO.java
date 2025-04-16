package com.auto_mendes.backend.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ModelRequestDTO(
		@NotNull(message = "Nome não deve ser nulo.")
		@NotEmpty(message = "Nome não deve ser vázio.")
		@Size(max = 50, message = "Nome deve ter até 50 caracteres.")
		String name,
		@NotNull(message = "Nome da marca não deve ser nulo.")
		@NotEmpty(message = "Nome da marca não deve ser vázio.")
		@Size(max = 50, message = "Nome da marca deve ter até 50 caracteres.")
		String brandName
) {}