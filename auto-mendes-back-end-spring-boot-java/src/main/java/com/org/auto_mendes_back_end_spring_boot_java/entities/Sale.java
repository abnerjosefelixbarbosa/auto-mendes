package com.org.auto_mendes_back_end_spring_boot_java.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "sales")
public class Sale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "sale_date", nullable = false)
	private LocalDate date;
	@Column(name = "sale_time", nullable = false)
	private LocalTime time;
	@Column(name = "total", nullable = false, scale = 2)
	private BigDecimal total;
	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;
	@OneToMany(mappedBy = "sale", fetch = FetchType.LAZY)
	private List<SalerVehicle> salerVehicles;
}