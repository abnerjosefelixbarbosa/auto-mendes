package com.auto_mendes.backend.dto;

import java.math.BigDecimal;

import com.auto_mendes.backend.enums.BoxgearType;
import com.auto_mendes.backend.enums.VehicleType;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class VehicleRequestDTO {
    private String plate;
    @NotNull(message = "Tipo de câmbio  não deve ser nulo.")
    private BoxgearType transmissionType;
    @NotNull(message = "Preço não deve ser nulo")
    private BigDecimal price;
    @NotNull(message = "Tipo de veiculo não deve ser nulo")
    private VehicleType vehicleType;
    @NotNull(message = "Nome do modelo não deve ser nulo ou vazio")
    @NotEmpty(message = "Nome do modelo não deve ser nulo ou vazio")
    @Size(max = 50, message = "Nome do modelo deve ter no máximo 50 caracteres.")
	private String modelName;
}