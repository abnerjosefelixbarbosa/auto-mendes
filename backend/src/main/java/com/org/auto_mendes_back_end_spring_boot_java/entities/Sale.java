package com.org.auto_mendes_back_end_spring_boot_java.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.org.auto_mendes_back_end_spring_boot_java.enums.PaymentType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "sales")
public class Sale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	@Column(nullable = false)
	private LocalDate saleDate;
	@Column(nullable = false)
	private LocalTime saleTime;
	@Column(nullable = false, scale = 2)
	private BigDecimal total;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;
	@ManyToOne
	@JoinColumn(name = "saler_id", nullable = false)
	private Saler saler;
	@OneToMany(mappedBy = "sale", fetch = FetchType.LAZY)
	private List<SaleVehicle> saleVehicles;
}