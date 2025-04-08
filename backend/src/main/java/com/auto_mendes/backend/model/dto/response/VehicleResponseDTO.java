package com.auto_mendes.backend.model.dto.response;

import java.math.BigDecimal;

import com.auto_mendes.backend.model.enums.TransmissionType;

public record VehicleResponseDTO(
		String id,
		String plate,
		TransmissionType transmissionType,
		BigDecimal price,
		String modelName
) {}