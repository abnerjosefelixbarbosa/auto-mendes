package com.org.auto_mendes_back_end_spring_boot_java.dtos.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "DTO de resposta da marca")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarkResponseDTO {
	@Schema(description = "ID da marca")
	private String id;
	@Schema(description = "Nome da marca")
	private String name;
}