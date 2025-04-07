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
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "car_tb")
@PrimaryKeyJoinColumn(name = "id")
public class Car extends Vehicle {
	private static final long serialVersionUID = 1L;

	public Car(String id, String plate, TransmissionType transmissionType, BigDecimal price, Model model,
			List<SaleVehicle> saleVehicles) {
		super(id, plate, transmissionType, price, model, saleVehicles);
	}

	public void update(Car car) {
		this.setModel(car.getModel());
		this.setPlate(car.getPlate());
		this.setPrice(car.getPrice());
		this.setTransmissionType(car.getTransmissionType());
	}
}