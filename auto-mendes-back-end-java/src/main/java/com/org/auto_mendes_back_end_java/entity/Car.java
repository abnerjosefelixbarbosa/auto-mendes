package com.org.auto_mendes_back_end_java.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false)
	private String id;
	@Column(name = "plate", nullable = false, unique = true)
	private String plate;
	@Column(name = "color", nullable = false)
	private String color;
	@Column(name = "car_vaule", nullable = false)
	private BigDecimal value;
	@Column(name = "car_year", nullable = false)
	private String year;
	@ManyToOne
	@JoinColumn(name = "model_id", nullable = false)
	private Model model;
	@ManyToOne
	@JoinColumn(name = "sale_id", nullable = false)
	private Sale sale;
}