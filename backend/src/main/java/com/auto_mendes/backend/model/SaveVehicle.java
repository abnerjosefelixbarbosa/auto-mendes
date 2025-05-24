package com.auto_mendes.backend.model;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "save_vehicle_tb")
public class SaveVehicle implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private SaleVehicleId saleVehicleId;
    private Integer quantity;
}
