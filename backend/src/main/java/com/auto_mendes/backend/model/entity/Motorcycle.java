package com.auto_mendes.backend.model.entity;

import java.math.BigDecimal;
import java.util.List;

import com.auto_mendes.backend.model.enums.TransmissionType;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity
@Table(name = "motorcycle_tb")
@PrimaryKeyJoinColumn(name = "id")
public class Motorcycle extends Vehicle {
	private static final long serialVersionUID = 1L;

	public Motorcycle(String id, String plate, TransmissionType transmissionType, BigDecimal price, Model model,
			List<SaleVehicle> saleVehicles) {
		super(id, plate, transmissionType, price, model, saleVehicles);
	}
}