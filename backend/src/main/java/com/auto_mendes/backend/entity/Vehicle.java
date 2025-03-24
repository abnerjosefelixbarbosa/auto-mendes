package com.auto_mendes.backend.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.auto_mendes.backend.enums.TransmissionType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String plate;
	@Enumerated(EnumType.STRING)
	private TransmissionType transmissionType;
	private BigDecimal price;
	private Model model;
	private List<SaleVehicle> saleVehicles;
}