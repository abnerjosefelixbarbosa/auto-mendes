package com.auto_mendes.backend.model.entity;

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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_tb")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	String id;
	@Column(nullable = false, length = 100)
	String name;
	@Column(nullable = false, unique = true, length = 100)
	String email;
	@Column(nullable = false, unique = true, length = 10)
	String matriculation;
	@Column(nullable = false, unique = true, length = 30)
	String phone;
	@Column(nullable = false)
	LocalDate birthDate;
}