package com.auto_mendes.backend.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.auto_mendes.backend.model.enums.TransmissionType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehicle_tb")
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(length = 20)
	private String plate;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TransmissionType transmissionType;
	@Column(nullable = false, precision = 20, scale = 2)
	private BigDecimal price;
	@ManyToOne
	@JoinColumn(name = "model_id")
	private Model model;
	@OneToMany(mappedBy = "vehicle")
	private List<SaleVehicle> saleVehicles;
}