package com.auto_mendes.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "manager_tb")
@PrimaryKeyJoinColumn(name = "id")
public class Manager extends Employee {
	private static final long serialVersionUID = 1L;
	
	public void updateManagerFields(Manager source, Manager target) {
		target.setName(source.getName());
		target.setEmail(source.getEmail());
		target.setMatriculation(source.getMatriculation());
		target.setPhone(source.getPhone());
		target.setBirthDate(source.getBirthDate());
		target.setCommission(source.getCommission());
	}
}