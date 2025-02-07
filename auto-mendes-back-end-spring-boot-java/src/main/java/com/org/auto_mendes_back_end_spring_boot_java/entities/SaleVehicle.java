package com.org.auto_mendes_back_end_spring_boot_java.entities;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "sales_vehicles")
public class SaleVehicle implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private SaleVehicleId id;
	@MapsId("saleId")
	@ManyToOne
	private Sale sale;
	@MapsId("vehicleId")
	@ManyToOne
	private Vehicle vehicle;
}