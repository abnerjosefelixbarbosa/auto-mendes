package com.org.auto_mendes_back_end_spring_boot_java.entities;

import java.math.BigDecimal;
import java.util.List;

import com.github.f4b6a3.ulid.UlidCreator;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "salers")
@PrimaryKeyJoinColumn(name = "id")
public class Saler extends Employee {
	private static final long serialVersionUID = 1L;
	
	@Column(scale = 2)
	private BigDecimal commission;
	@OneToMany(mappedBy = "saler", fetch = FetchType.LAZY)
	private List<Sale> sales;

	public Saler(String id, String name, String cpf, String email, String telephone, BigDecimal salary,
			String matriculation, BigDecimal commission) {
		super(id, name, cpf, email, telephone, salary, matriculation);
		this.commission = commission;
		this.sales = null;
	}

	public Saler(EmployeeRequestDTO request) {
		super(UlidCreator.getUlid().toString(), request.getName(), request.getCpf(), request.getEmail(), request.getTelephone(),
				request.getSalary(), request.getMatriculation());
		this.commission = request.getCommission();
		this.sales = null;
	}
}