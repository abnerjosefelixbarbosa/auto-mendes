package com.org.auto_mendes_back_end_spring_boot_java.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

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
@Table(name = "sales")
public class Sale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "sale_date")
	private LocalDate date;
	@Column(name = "sale_time")
	private LocalTime time;
	@Column(name = "total_value")
	private BigDecimal totalValue;
}