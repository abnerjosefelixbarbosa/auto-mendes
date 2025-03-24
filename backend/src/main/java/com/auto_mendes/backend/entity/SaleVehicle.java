package com.auto_mendes.backend.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleVehicle implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private SaleVehicleId saleVehicleId;
	private Integer quantity;
	private Sale sale;
	private Vehicle vehicle;
}