package com.auto_mendes.backend.persistence.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.auto_mendes.backend.enums.PaymentType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "sale_tb")
public class Sale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(name = "sale_date_time", nullable = false)
	private LocalDateTime dateTime;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private PaymentType paymentType;
	@Column(nullable = false, precision = 20, scale = 2)
	private BigDecimal total;
	@ManyToOne
	@JoinColumn(name = "saler_id")
	private Saler saler;
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	@OneToMany(mappedBy = "sale")
	private List<SaleVehicle> saleVehicles;
}