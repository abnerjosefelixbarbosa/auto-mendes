package com.org.auto_mendes_back_end_java.model.entity;

import java.io.Serializable;
import java.time.LocalDate;

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
@Table(name = "customers")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false)
	private String id;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "cpf", nullable = false, unique = true)
	private String cpf;
	@Column(name = "rg", nullable = false, unique = true)
	private String rg;
	@Column(name = "contact", nullable = false, unique = true)
	private String contact;
	@Column(name = "birth_date", nullable = false)
	private LocalDate birthDate;
}