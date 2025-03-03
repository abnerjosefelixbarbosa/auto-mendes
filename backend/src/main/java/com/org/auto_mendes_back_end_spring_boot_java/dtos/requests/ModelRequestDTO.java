package com.org.auto_mendes_back_end_spring_boot_java.dtos.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "DTO de requisição do modelo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModelRequestDTO {
	@Schema(description = "Nome do modelo")
	@NotNull(message = "Nome não deve ser nulo")
	@NotEmpty(message = "Nome não deve ser vazio")
	@Size(message = "Nome deve ter até 30 caracteres", max = 30)
	private String name;
	@Schema(description = "Nome da marca")
	@NotNull(message = "Nome da marca não deve ser nulo")
	@NotEmpty(message = "Nome da marca não deve ser vazio")
	@Size(message = "Nome da marca deve ter até 30 caracteres", max = 30)
	private String markName;
}
