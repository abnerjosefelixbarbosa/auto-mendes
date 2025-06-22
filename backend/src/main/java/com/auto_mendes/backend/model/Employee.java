package com.auto_mendes.backend.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.auto_mendes.backend.dto.EmployeeRequestDTO;
import com.auto_mendes.backend.enums.EmployeeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "employee_tb")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id")
	private String id;
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	@Column(name = "email", nullable = false, unique = true, length = 100)
	private String email;
	@Column(name = "matriculation", nullable = false, unique = true, length = 10)
	private String matriculation;
	@Column(name = "phone", nullable = false, unique = true, length = 30)
	private String phone;
	@Column(name = "birth_date", nullable = false)
	private LocalDate birthDate;
	@Column(name = "commission")
	private BigDecimal commission;
	@Enumerated(EnumType.STRING)
	@Column(name = "employee_type", nullable = false)
	private EmployeeType employeeType;
	@OneToMany(mappedBy = "employee")
	private List<Sale> sales;
	
	public Employee(EmployeeRequestDTO dto) {
		BeanUtils.copyProperties(dto, this);
	}
}