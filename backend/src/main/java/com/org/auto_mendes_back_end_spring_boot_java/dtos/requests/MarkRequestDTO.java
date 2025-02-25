package com.org.auto_mendes_back_end_spring_boot_java.dtos.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "DTO de requisição da marca")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarkRequestDTO {
	@Schema(description = "Nome da marca")
	@NotEmpty(message =  "Nome deve ser obrigatório")
	@NotNull(message = "Nome deve ser obrigatório")
	@Size(message = "Nome deve ter 30 até caracteres", max = 30)
	private String name;
}