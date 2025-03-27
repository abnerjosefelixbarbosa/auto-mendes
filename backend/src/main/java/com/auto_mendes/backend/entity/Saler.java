package com.auto_mendes.backend.entity;

import java.math.BigDecimal;
import java.util.List;

import com.auto_mendes.backend.dto.request.EmployeeRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "saler_tb")
@PrimaryKeyJoinColumn(name = "id")
public class Saler extends Employee {
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false, precision = 20, scale = 2)
	private BigDecimal commission;
	@OneToMany(mappedBy = "saler")
	private List<Sale> sales;
	
	public Saler(EmployeeRequestDTO request) {
		super(null, request.name(), request.email(), request.registration(), request.phone(), request.birthDate());
		
		this.commission = request.commission();
	}
}