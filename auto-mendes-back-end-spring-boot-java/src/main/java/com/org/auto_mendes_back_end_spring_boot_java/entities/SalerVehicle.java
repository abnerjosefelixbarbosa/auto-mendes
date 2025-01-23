package com.org.auto_mendes_back_end_spring_boot_java.entities;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
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
@Table(name = "saler_vehicles")
public class SalerVehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SalerVehicleId id;
	@ManyToOne
	@MapsId(value = "saleId")
	private Sale sale;
	@ManyToOne
	@MapsId(value = "vehicleId")
	private Vehicle vehicle;
}