package com.auto_mendes.backend.dto;

import java.math.BigDecimal;

import com.auto_mendes.backend.enums.TransmissionType;
import com.auto_mendes.backend.enums.VehicleType;

import lombok.Data;

@Data
public class VehicleRequestDTO {
    private String plate;
    private TransmissionType transmissionType;
    private BigDecimal price;
    private VehicleType vehicleType;
	private String modelName;
}