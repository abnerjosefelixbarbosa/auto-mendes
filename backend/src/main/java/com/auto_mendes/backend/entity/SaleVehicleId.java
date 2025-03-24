package com.auto_mendes.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleVehicleId {
	private String saleId;
	private String vehicleId;
}