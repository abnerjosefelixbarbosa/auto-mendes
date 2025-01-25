package com.org.auto_mendes_back_end_spring_boot_java.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.org.auto_mendes_back_end_spring_boot_java.enums.EmployeeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	@Column(name = "cpf", nullable = false, unique = true, length = 20)
	private String cpf;
	@Column(name = "birth_date", nullable = false)
	private LocalDate birthDate;	
	@Column(name = "email", nullable = false, unique = true, length = 50)
	private String email;
	@Column(name = "contact", nullable = false, unique = true, length = 30)
	private String contact;
	@Column(name = "matriculation", nullable = false, unique = true, length = 10)
	private String matriculation;
	@Column(name = "commission", scale = 2)
	private BigDecimal commission;
	@Column(name = "employee_type", nullable = false)
	private EmployeeType employeeType;
	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
	private List<Sale> sales;
}
