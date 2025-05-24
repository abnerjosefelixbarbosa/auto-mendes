package com.auto_mendes.backend.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.auto_mendes.backend.enums.TransmissionType;
import com.auto_mendes.backend.enums.VehicleType;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "save_vehicle_tb")
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
    private String plate;
    private TransmissionType transmissionType;
    private BigDecimal price;
    private VehicleType vehicleType;
}