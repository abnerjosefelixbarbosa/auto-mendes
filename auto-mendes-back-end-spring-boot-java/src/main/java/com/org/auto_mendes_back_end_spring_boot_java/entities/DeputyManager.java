package com.org.auto_mendes_back_end_spring_boot_java.entities;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity
@Table(name = "deputy_managers")
@PrimaryKeyJoinColumn(name = "id")
public class DeputyManager extends Employee {
	private static final long serialVersionUID = 1L;

	public DeputyManager(String id, String name, String cpf, String email, String telephone, BigDecimal salary,
			String matriculation) {
		super(id, name, cpf, email, telephone, salary, matriculation);
	}
}