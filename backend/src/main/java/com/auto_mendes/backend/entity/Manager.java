package com.auto_mendes.backend.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "manager_tb")
@PrimaryKeyJoinColumn(name = "id")
public class Manager extends Employee {
	private static final long serialVersionUID = 1L;

	public Manager(String id, String name, String email, String registration, String phone, LocalDate birthDate) {
		super(id, name, email, registration, phone, birthDate);
	}
}