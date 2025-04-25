package com.auto_mendes.backend.dto.response;

import java.math.BigDecimal;

public record VehicleResponseDTO(
		String id,
		String plate,
		BigDecimal price,
		String modelName
) {}