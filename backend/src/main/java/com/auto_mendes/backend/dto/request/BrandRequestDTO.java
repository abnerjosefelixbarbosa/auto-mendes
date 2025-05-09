package com.auto_mendes.backend.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandRequestDTO {
	@NotNull(message = "Nome nulo.")
	@NotEmpty(message = "Nome vázio.")
	@Size(max = 50, message = "Nome com no maximo 50 caracteres.")
	private String name;
}