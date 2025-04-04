package com.auto_mendes.backend.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "saler_tb")
@PrimaryKeyJoinColumn(name = "id")
public class Saler extends Employee {
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false, precision = 20, scale = 2)
	private BigDecimal commission;
	@OneToMany(mappedBy = "saler")
	private List<Sale> sales;
	
	public Saler(String id, String name, String email, String matriculation, String phone, LocalDate birthDate,
			BigDecimal commission) {
		super(id, name, email, matriculation, phone, birthDate);
		this.commission = commission;
	}
	
	public void update(Saler saler) {
		this.birthDate = saler.getBirthDate();
		this.email = saler.getEmail();
		this.matriculation = saler.getMatriculation();
		this.name = saler.getName();
		this.phone = saler.getPhone();
		this.commission = saler.getCommission();
	}
}