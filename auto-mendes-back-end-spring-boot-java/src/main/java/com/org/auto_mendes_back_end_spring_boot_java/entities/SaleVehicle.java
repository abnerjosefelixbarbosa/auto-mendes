package com.org.auto_mendes_back_end_spring_boot_java.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	@Id
	private String id;
	@ManyToOne
	@JoinColumn(name = "sale_id", nullable = false)
	private Sale sale;
	@ManyToOne
	@JoinColumn(name = "vehicle_id", nullable = false)
	private Vehicle vehicle;
}