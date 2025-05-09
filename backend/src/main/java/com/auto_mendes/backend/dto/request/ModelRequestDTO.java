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
public class ModelRequestDTO {
	@NotNull(message = "Nome nulo.")
	@NotEmpty(message = "Nome vázio.")
	@Size(max = 50, message = "Nome até no máximo 50 caracteres.")
	private String name;
	@NotNull(message = "Nome nulo.")
	@NotEmpty(message = "Nome vázio.")
	@Size(max = 50, message = "Nome até no máximo 50 caracteres.")
	private String brandName;
}