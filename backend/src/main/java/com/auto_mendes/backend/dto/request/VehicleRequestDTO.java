package com.auto_mendes.backend.dto.request;

import java.math.BigDecimal;

import com.auto_mendes.backend.enums.TransmissionType;
import com.auto_mendes.backend.enums.VehicleType;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleRequestDTO {
	@Size(message = "Placa até no máximo 20 caracteres.")
	private String plate;
	@NotNull(message = "Tipo da transmissão nulo.")
	private TransmissionType transmissionType;
	@NotNull(message = "Preço nulo.")
	private BigDecimal price;
	@NotNull(message = "Nome nulo.")
	@NotEmpty(message = "Nome vázio.")
	private String modelName;
	@NotNull(message = "Tipo do veículo null.")
	private VehicleType vehicleType;
}