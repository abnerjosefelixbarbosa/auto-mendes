package com.org.auto_mendes_back_end_spring_boot_java.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@DiscriminatorValue(value = "3")
public class Saler extends Employee {
	private static final long serialVersionUID = 1L;
	
	@Column(scale = 2)
	private BigDecimal commission;
}