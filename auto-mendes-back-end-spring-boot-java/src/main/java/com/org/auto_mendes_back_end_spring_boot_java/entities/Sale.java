package com.org.auto_mendes_back_end_spring_boot_java.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "sales")
public class Sale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	@Column(nullable = false)
	private String saleDate;
	@Column(nullable = false)
	private String saleTime;
	@Column(nullable = false, scale = 2)
	private BigDecimal total;
	@Column(nullable = false)
	private String paymentType;
	private String customer;
	private String employee;
	private String saleVehicles;
}