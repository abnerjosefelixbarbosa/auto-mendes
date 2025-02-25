package com.org.auto_mendes_back_end_spring_boot_java.dtos.requests;

import java.math.BigDecimal;

import com.org.auto_mendes_back_end_spring_boot_java.enums.ExchangeType;
import com.org.auto_mendes_back_end_spring_boot_java.enums.VehicleType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleRequestDTO {
	private String plate;
	private String color;
	private BigDecimal vehicleValue;
	private String vehicleYear;
	private ExchangeType exchangeType;
	private VehicleType vehicleType;
	private String modelName;
}