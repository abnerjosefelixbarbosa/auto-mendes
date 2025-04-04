package com.auto_mendes.backend.model.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sale_vehicle_tb")
public class SaleVehicle implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private SaleVehicleId saleVehicleId;
	@Column(nullable = false)
	private Integer quantity;
	@MapsId("saleId")
	@ManyToOne
	@JoinColumn(name = "sale_id")
	private Sale sale;
	@MapsId("vehicleId")
	@ManyToOne
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;
}