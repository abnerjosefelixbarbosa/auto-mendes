package com.auto_mendes.backend.model.dto.request;

import java.math.BigDecimal;

import com.auto_mendes.backend.model.enums.TransmissionType;
import com.auto_mendes.backend.model.enums.VehicleType;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record VehicleRequestDTO(
		@Size(message = "Placa deve ter até 20 caracteres.")
		String plate,
		@NotNull(message = "Tipo da transmissão não deve ser nulo.")
		TransmissionType transmissionType,
		@NotNull(message = "Preço não deve ser nulo.")
		BigDecimal price,
		@NotNull(message = "Nome do modelo não deve ser nulo.")
		@NotEmpty(message = "Nome do modelo não deve ser vázio.")
		String modelName,
		@NotNull(message = "Tipo do veículo não deve ser null.")
		VehicleType vehicleType
) {}