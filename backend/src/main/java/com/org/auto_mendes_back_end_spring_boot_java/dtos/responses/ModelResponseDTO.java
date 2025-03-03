package com.org.auto_mendes_back_end_spring_boot_java.dtos.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "DTO de resposta do modelo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelResponseDTO {
	@Schema(description = "ID do modelo")
	private String id;
	@Schema(description = "Nome do modelo")
	private String name;
	@Schema(description = "Nome da marca")
	private String markName;
}
