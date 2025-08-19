package com.auto_mendes.backend.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ModelRequestDTO {
	@NotEmpty(message = "Nome não deve ser vazio ou nulo.")
	@NotNull(message = "Nome não deve ser vazio ou nulo.")
	@Size(max = 50, message = "Nome deve ter no máximo 50 caracteres.")
	private String name;
	@NotEmpty(message = "Nome da marca não deve ser vazio ou nulo.")
	@NotNull(message = "Nome da marca não deve ser vazio ou nulo.")
	@Size(max = 50, message = "Nome da marca deve ter no máximo 50 caracteres.")
	private String brandName;
}