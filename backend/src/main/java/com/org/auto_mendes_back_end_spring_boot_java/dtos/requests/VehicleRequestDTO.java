package com.org.auto_mendes_back_end_spring_boot_java.dtos.requests;

import java.math.BigDecimal;

import com.org.auto_mendes_back_end_spring_boot_java.enums.ExchangeType;
import com.org.auto_mendes_back_end_spring_boot_java.enums.VehicleType;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "DTO de requisição do veiculo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleRequestDTO {
	@Schema(description = "Placa do veiculo")
	@Size(message = "Placa deve ter até 20 caracteres", max = 20)
	private String plate;
	@Schema(description = "Cor do veiculo")
	@NotEmpty(message = "Cor deve ser obrigatória")
	@NotNull(message = "Cor deve ser obrigatória")
	@Size(message = "Cor deve ter até 20 caracteres", max = 20)
	private String color;
	@Schema(description = "Valor do veiculo")
	@NotNull(message = "Valor do veiculo deve ser obrigatório")
	private BigDecimal vehicleValue;
	@Schema(description = "Ano do veiculo")
	@NotEmpty(message = "Ano do veiculo deve ser obrigatório")
	@NotNull(message = "Ano do veiculo deve ser obrigatório")
	@Pattern(message = "Ano do veiculo deve ter 4 caracteres", regexp = "^\\d{4}$")
	private String vehicleYear;
	@Schema(description = "Tipo do câmbio do veiculo")
	@NotNull(message = "Tipo do câmbio veiculo deve ser obrigatória")
	private ExchangeType exchangeType;
	@Schema(description = "Tipo do veiculo")
	@NotNull(message = "Tipo do veiculo deve ser obrigatória")
	private VehicleType vehicleType;
	@Schema(description = "Nome do modelo do veiculo")
	@NotEmpty(message = "Nome do modelo deve ser obrigatório")
	@NotNull(message = "Nome do modelo deve ser obrigatório")
	@Size(message = "Nome do modelo deve ter até 30 caracteres", max = 30)
	private String modelName;
}