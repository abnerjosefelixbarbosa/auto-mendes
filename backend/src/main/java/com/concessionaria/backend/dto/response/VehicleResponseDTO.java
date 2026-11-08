package com.concessionaria.backend.dto.response;

import java.math.BigDecimal;

import com.concessionaria.backend.entity.enums.TransmissionType;
import com.concessionaria.backend.entity.enums.VehicleStatus;

public record VehicleResponseDTO(
		String id,
		String plate,
		TransmissionType transmissionType,
		VehicleStatus vehicleStatus,
		String color,
		BigDecimal price,
		ModelResponseDTO model
) {}