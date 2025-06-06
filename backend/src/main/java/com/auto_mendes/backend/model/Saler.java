package com.auto_mendes.backend.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "saler_tb")
@PrimaryKeyJoinColumn(name = "id")
public class Saler extends Employee {
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "employee")
	private List<Sale> sales;
	
	public void updateSalerFields(Saler source, Saler target) {
		target.setName(source.getName());
		target.setEmail(source.getEmail());
		target.setMatriculation(source.getMatriculation());
		target.setPhone(source.getPhone());
		target.setBirthDate(source.getBirthDate());
		target.setCommission(source.getCommission());
	}
}