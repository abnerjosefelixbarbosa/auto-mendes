package com.org.auto_mendes_back_end_spring_boot_java.dtos.queries;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListVehiclesQueryDTO {
	private String id;
	private String plate;
	private String color;
	private BigDecimal vehicleValue;
	private String vehicleYear;
	private String exchangeType;
	private String vehicleType;
	private String modelName;
}
