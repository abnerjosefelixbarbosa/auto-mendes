package com.auto_mendes.backend.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class SaleVehicleId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String saleId;
    private String vehicleId;
}
