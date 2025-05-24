package com.auto_mendes.backend.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.auto_mendes.backend.enums.PaymentType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "sale_tb")
public class Sale implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id")
	private String id;
	@Column(name = "sale_date_time", nullable = false)
	private LocalDateTime dateTime;
	@Column(name = "payment_type", nullable = false)
	private PaymentType paymentType;
	@Column(name = "total", nullable = false)
	private BigDecimal total;
	@ManyToOne
	@JoinColumn(columnDefinition = "customer_id", nullable = false)
	private Customer customer;
	@ManyToOne
	@JoinColumn(columnDefinition = "employee_id", nullable = false)
	private Employee employee;
}