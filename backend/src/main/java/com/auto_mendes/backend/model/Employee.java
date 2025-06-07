package com.auto_mendes.backend.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
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
	
	public void updateEmployeeFields(Employee source, Employee target) {
		target.setName(source.getName());
		target.setEmail(source.getEmail());
		target.setMatriculation(source.getMatriculation());
		target.setPhone(source.getPhone());
		target.setBirthDate(source.getBirthDate());
	}
}