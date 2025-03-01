package com.org.auto_mendes_back_end_spring_boot_java.dtos.responses;

import java.math.BigDecimal;

import com.org.auto_mendes_back_end_spring_boot_java.enums.ExchangeType;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "DTO de resposta do veiculo")
@Data
@NoArgsConstructor
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
	
	public VehicleResponseDTO(String id, String plate, String color, BigDecimal vehicleValue, String vehicleYear,
			int exchangeType, String modelName) {
		this.id = id;
		this.plate = plate;
		this.color = color;
		this.vehicleValue = vehicleValue;
		this.vehicleYear = vehicleYear;
		this.modelName = modelName;
		
		switch (exchangeType) {
		case 0:
			this.exchangeType = ExchangeType.MANUAL;
			break;
		case 1:
			this.exchangeType = ExchangeType.AUTOMATIC;
			break;
		case 2:
			this.exchangeType = ExchangeType.AUTOMATED;
			break;
		case 3:
			this.exchangeType = ExchangeType.CVT;
			break;
		case 4:
			this.exchangeType = ExchangeType.SEMI_AUTOMATIC;
			break;
		case 5:
			this.exchangeType = ExchangeType.DCT;
			break;
		case 6:
			this.exchangeType = ExchangeType.QUICK_SHIFTER;
			break;
		default:
			break;
		}
	}
	
	
}