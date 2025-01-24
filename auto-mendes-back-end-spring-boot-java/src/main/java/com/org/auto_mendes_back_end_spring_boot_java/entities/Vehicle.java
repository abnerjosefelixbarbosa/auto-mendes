package com.org.auto_mendes_back_end_spring_boot_java.entities;

import java.io.Serializable;
import java.util.List;

import com.org.auto_mendes_back_end_spring_boot_java.enums.ExchangeType;
import com.org.auto_mendes_back_end_spring_boot_java.enums.VehicleType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehicles")
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "plate")
	private String plate;
	@Column(name = "color", nullable = false)
	private String color;
	@Column(name = "vehicle_value", nullable = false)
	private String value;
	@Column(name = "vehicle_type", nullable = false)
	private VehicleType vehicleType;
	@Column(name = "gear_type", nullable = false)
	private ExchangeType exchangeType;
	@ManyToOne
	@JoinColumn(name = "model_id", nullable = false)
	private Model model;
	@OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
	private List<SalerVehicle> salerVehicles;
}
