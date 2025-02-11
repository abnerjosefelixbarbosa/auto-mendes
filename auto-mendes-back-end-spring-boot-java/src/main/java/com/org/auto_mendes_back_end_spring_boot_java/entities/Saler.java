package com.org.auto_mendes_back_end_spring_boot_java.entities;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@DiscriminatorValue(value = "2")
public class Saler extends Employee {
	private static final long serialVersionUID = 1L;
	
	@Column(scale = 2)
	private BigDecimal commission;

	public Saler(String id, String name, String cpf, String email, String telephone, BigDecimal salary,
			String matriculation, List<Sale> sales, BigDecimal commission) {
		super(id, name, cpf, email, telephone, salary, matriculation, sales);
		this.commission = commission;
	}
}