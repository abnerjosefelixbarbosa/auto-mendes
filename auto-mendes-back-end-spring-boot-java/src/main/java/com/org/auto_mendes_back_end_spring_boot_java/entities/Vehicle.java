package com.org.auto_mendes_back_end_spring_boot_java.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.org.auto_mendes_back_end_spring_boot_java.enums.ExchangeType;
import com.org.auto_mendes_back_end_spring_boot_java.enums.VehicleType;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "vehicles")
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String plate;
	private String color;
	private BigDecimal vehicleValue;
	private ExchangeType exchangeType;
	private VehicleType vehicleType;
	@ManyToOne
	@JoinColumn(name = "model_id", nullable = false)
	private Model model;
	@OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
	private List<SaleVehicle> saleVehicles;
}
