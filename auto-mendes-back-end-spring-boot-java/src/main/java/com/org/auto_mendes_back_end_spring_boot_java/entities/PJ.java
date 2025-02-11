package com.org.auto_mendes_back_end_spring_boot_java.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "pjs")
@PrimaryKeyJoinColumn(name = "id")
public class PJ extends Customer {
	private static final long serialVersionUID = 1L;
	
	@Column(length = 18, nullable = false, unique = true)
	private String cnpj;

	public PJ(String id, String name, String telephone, String cnpj) {
		super(id, name, telephone, null);
		this.cnpj = cnpj;
	}
}