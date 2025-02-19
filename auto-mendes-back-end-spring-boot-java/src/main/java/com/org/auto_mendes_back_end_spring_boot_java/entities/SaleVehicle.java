package com.org.auto_mendes_back_end_spring_boot_java.entities;

import java.io.Serializable;

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
@Table(name = "sales_vehicles")
public class SaleVehicle implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private SaleVehicleId id;
	@MapsId("saleId")
	@ManyToOne
	@JoinColumn(name = "sale_id")
	private Sale sale;
	@MapsId("vehicleId")
	@ManyToOne
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;
}