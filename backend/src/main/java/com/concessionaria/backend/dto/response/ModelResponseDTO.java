package com.concessionaria.backend.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Dados de resposta do modelo.")
public record ModelResponseDTO(
		@Schema(description = "Id do modelo.")
		String id,
		@Schema(description = "Nome do modelo.")
		String name,
		BrandResponseDTO brand
) {}