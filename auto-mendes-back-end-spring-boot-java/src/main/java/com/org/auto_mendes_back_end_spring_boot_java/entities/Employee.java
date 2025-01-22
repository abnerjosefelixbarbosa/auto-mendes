package com.org.auto_mendes_back_end_spring_boot_java.entities;

import java.io.Serializable;

import com.org.auto_mendes_back_end_spring_boot_java.enums.EmployeeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
	@Column(name = "birth_date")
	private String birthDate;
	@Column(name = "cpf")
	private String cpf;
	@Column(name = "name")
	private String name;
	@Column(name = "matriculation")
	private String matriculation;
	@Column(name = "email")
	private String email;
	@Column(name = "contact")
	private String contact;
	@Column(name = "type_employee")
	private EmployeeType typeEmployee;
}
