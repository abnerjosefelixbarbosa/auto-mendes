package com.org.auto_mendes_back_end_spring_boot_java.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	@Column(nullable = false, unique = true, length = 100)
	private String name;
	@Column(nullable = false, unique = true, length = 14)
	private String cpf;
	@Column(nullable = false, unique = true, length = 50)
	private String email;
	@Column(nullable = false, unique = true, length = 20)
	private String telephone;
	@Column(nullable = false, scale = 2)
	private BigDecimal salary;
	@Column(nullable = false, unique = true, length = 10)
	private String matriculation;

	public Employee(EmployeeRequestDTO request) {
		this(null, request.getName(), request.getCpf(), request.getEmail(), request.getTelephone(), request.getSalary(),
				request.getMatriculation());
	}
}
