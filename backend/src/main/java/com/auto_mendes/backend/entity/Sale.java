package com.auto_mendes.backend.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.auto_mendes.backend.enums.PaymentType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity
//@Table(name = "sale_tb")
public class Sale implements Serializable {
	private static final long serialVersionUID = 1L;

	//@Id
	//@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	//@Column(name = "sale_date_time", nullable = false)
	private LocalDateTime dateTime;
	@Enumerated(EnumType.STRING)
	//@Column(nullable = false)
	private PaymentType paymentType;
	//@Column(nullable = false)
	private BigDecimal total;
	//@ManyToOne
	//@JoinColumn(name = "saler_id")
	private Saler saler;
	private Customer customer;
	private List<SaleVehicle> saleVehicles;
}