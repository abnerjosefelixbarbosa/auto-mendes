package com.org.auto_mendes_back_end_spring_boot_java.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "salers")
public class Saler extends Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "commission")
	private BigDecimal commission;
}