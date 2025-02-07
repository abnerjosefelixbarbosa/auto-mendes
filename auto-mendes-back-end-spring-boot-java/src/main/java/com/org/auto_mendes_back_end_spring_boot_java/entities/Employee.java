package com.org.auto_mendes_back_end_spring_boot_java.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.org.auto_mendes_back_end_spring_boot_java.enums.EmployeeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employees")
public class Employee implements Serializable{
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
	@Column(scale = 2)
	private BigDecimal commission;
	@Column(nullable = false)
	private EmployeeType employeeType;
	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
	private List<Sale> sales;
}
