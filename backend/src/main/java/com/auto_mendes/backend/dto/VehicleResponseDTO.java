package com.auto_mendes.backend.dto;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;

import com.auto_mendes.backend.enums.BoxgearType;
import com.auto_mendes.backend.enums.VehicleType;
import com.auto_mendes.backend.model.Vehicle;

import lombok.Data;

@Data
public class VehicleResponseDTO {
	private String id;
    private String plate;
    private BoxgearType transmissionType;
    private BigDecimal price;
    private VehicleType vehicleType;
	private String modelName;
	
	public VehicleResponseDTO(Vehicle vehicle) {
		BeanUtils.copyProperties(vehicle, this);
		this.modelName = vehicle.getModel().getName();
	}
}