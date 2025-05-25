package com.auto_mendes.backend.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "sale_vehicle_tb")
public class SaleVehicle implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private SaleVehicleId saleVehicleId;
	@Column(name = "quantity", nullable = false)
    private Integer quantity;
	@ManyToOne
	@MapsId(value = "saleId")
	@JoinColumn(name = "sale_id", nullable = false)
    private Sale sale;
	@ManyToOne
	@MapsId(value = "vehicleId")
	@JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;
}
