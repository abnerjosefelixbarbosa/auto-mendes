package com.org.auto_mendes_back_end_spring_boot_java.dtos.responses;

import java.math.BigDecimal;

import com.org.auto_mendes_back_end_spring_boot_java.enums.ExchangeType;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "DTO de resposta do veiculo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleResponseDTO {
	@Schema(description = "ID do veiculo")
	private String id;
	@Schema(description = "Placa do veiculo")
	private String plate;
	@Schema(description = "Cor do veiculo")
	private String color;
	@Schema(description = "Valor do veiculo")
	private BigDecimal vehicleValue;
	@Schema(description = "Ano do veiculo")
	private String vehicleYear;
	@Schema(description = "Tipo de cambio do veiculo")
	private ExchangeType exchangeType;
	@Schema(description = "Nome do modelo do veiculo")
	private String modelName;
}