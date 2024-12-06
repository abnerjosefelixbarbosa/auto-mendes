package com.org.auto_mendes_back_end_java.entity;

import java.io.Serializable;
import java.time.LocalDate;

import com.github.f4b6a3.ulid.Ulid;
import com.github.f4b6a3.ulid.UlidCreator;
import com.org.auto_mendes_back_end_java.dto.RegisterEmployeeRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", nullable = false)
	private String id;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "employee_type", nullable = false)
	@Enumerated(EnumType.STRING)
	private EmployeeType employeeType;
	@Column(name = "birth_date", nullable = false)
	private LocalDate birthDate;
	@Column(name = "cpf", nullable = false, unique = true)
	private String cpf;
	@Column(name = "rg", nullable = false, unique = true)
	private String rg;
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	@Column(name = "contact", nullable = false, unique = true)
	private String contact;
	
	public Employee(RegisterEmployeeRequest request) {
		Ulid ulid = UlidCreator.getUlid();
		id = ulid.toString();
		name = request.name();
		employeeType = EmployeeType.valueOf(request.employeeType().getValue()) ;
		birthDate = request.birthDate();
		cpf = request.cpf();
		rg = request.rg();
		email = request.email();
		contact = request.contact();
	}
}