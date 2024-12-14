package com.org.auto_mendes_back_end_java.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Sales")
public class Sale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false)
	private String id;
	@Column(name = "total", nullable = false)
	private BigDecimal total;
	@Column(name = "sale_date_time", nullable = false)
	private LocalDateTime dateTime;
	@Column(name = "customer_id", nullable = false)
	private Customer customer;
	@Column(name = "employee_id", nullable = false)
	private Employee employee;
}