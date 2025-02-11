package com.org.auto_mendes_back_end_spring_boot_java.entities;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity
@DiscriminatorValue(value = "1")
public class DeputyManager extends Employee {
	private static final long serialVersionUID = 1L;

	public DeputyManager(String id, String name, String cpf, String email, String telephone, BigDecimal salary,
			String matriculation, List<Sale> sales) {
		super(id, name, cpf, email, telephone, salary, matriculation, sales);
	}
}