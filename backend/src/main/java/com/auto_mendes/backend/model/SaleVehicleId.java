package com.auto_mendes.backend.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class SaleVehicleId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "sale_id")
	private String saleId;
	@Column(name = "vehicle_id")
    private String vehicleId;
}
