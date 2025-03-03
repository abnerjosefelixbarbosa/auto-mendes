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
	@Schema(description = "Placa")
	@Size(message = "Placa deve ter até 20 caracteres", max = 20)
	private String plate;
	@Schema(description = "Cor")
	@NotEmpty(message = "Cor não deve ser vazio")
	@NotNull(message = "Cor não deve ser nulo")
	@Size(message = "Cor deve ter até 20 caracteres", max = 20)
	private String color;
	@Schema(description = "Valor do veiculo")
	@NotNull(message = "Valor do veiculo não deve ser nulo")
	private BigDecimal vehicleValue;
	@Schema(description = "Ano do veiculo")
	@NotEmpty(message = "Ano do veiculo não deve ser vazio")
	@NotNull(message = "Ano do veiculo não deve ser null")
	@Pattern(message = "Ano do veiculo deve ter 4 caracteres numericos", regexp = "^\\d{4}$")
	private String vehicleYear;
	@Schema(description = "Tipo do câmbio")
	@NotNull(message = "Tipo do câmbio não deve ser nulo")
	private ExchangeType exchangeType;
	@Schema(description = "Nome do modelo do veiculo")
	@NotEmpty(message = "Nome do modelo não deve ser vazio")
	@NotNull(message = "Nome do modelo não deve ser nulo")
	@Size(message = "Nome do modelo deve ter até 30 caracteres", max = 30)
	private String modelName;
	@NotNull(message = "Tipo de veiculo não deve ser nulo")
	private VehicleType vehicleType;
}