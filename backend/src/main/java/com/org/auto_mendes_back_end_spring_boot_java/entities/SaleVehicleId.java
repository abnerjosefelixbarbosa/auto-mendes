package com.org.auto_mendes_back_end_spring_boot_java.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleVehicleId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String saleId;
	private String vehicleId;
}