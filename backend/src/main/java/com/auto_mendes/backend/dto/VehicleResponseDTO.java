package com.auto_mendes.backend.dto;

import java.math.BigDecimal;

import com.auto_mendes.backend.enums.TransmissionType;

public record VehicleResponseDTO(
		String id,
		String plate,
		TransmissionType transmissionType,
		BigDecimal price,
		String modelName
) {}