package com.org.auto_mendes_back_end_spring_boot_java.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "pfs")
@PrimaryKeyJoinColumn(name = "id")
public class PF extends Customer {
	private static final long serialVersionUID = 1L;
	
	@Column(length = 14, nullable = false, unique = true)
	private String cpf;
}