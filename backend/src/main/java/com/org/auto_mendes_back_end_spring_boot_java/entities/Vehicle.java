package com.org.auto_mendes_back_end_spring_boot_java.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.org.auto_mendes_back_end_spring_boot_java.enums.ExchangeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vehicles")
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	@Column(length = 20)
	private String plate;
	@Column(nullable = false, length = 20)
	private String color;
	@Column(nullable = false, scale = 2)
	private BigDecimal vehicleValue;
	@Column(nullable = false, length = 4)
	private String vehicleYear;
	@Column(nullable = false)
	private ExchangeType exchangeType;
	@ManyToOne
	@JoinColumn(name = "model_id", nullable = false)
	private Model model;
	@OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
	private List<SaleVehicle> saleVehicles;
}
