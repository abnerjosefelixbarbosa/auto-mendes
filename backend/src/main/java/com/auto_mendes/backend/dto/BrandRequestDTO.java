package com.auto_mendes.backend.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BrandRequestDTO {
	@NotNull(message = "Nome não deve ser nulo e vazio.")
	@NotEmpty(message = "Nome não deve ser nulo e vazio.")
	@Size(max = 50, message = "Nome deve ter no máximo 50 caracteres.")
	private String name;
}