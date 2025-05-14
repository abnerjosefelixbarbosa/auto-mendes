package com.auto_mendes.backend.dto.response;

import java.math.BigDecimal;

import com.auto_mendes.backend.enums.TransmissionType;
import com.auto_mendes.backend.enums.VehicleType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleResponseDTO {
	private String id;
	private String plate;
	private TransmissionType transmissionType;
	private BigDecimal price;
	private VehicleType vehicleType;
	private String modelName;
}