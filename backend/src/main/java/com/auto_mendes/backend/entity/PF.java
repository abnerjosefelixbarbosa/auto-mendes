package com.auto_mendes.backend.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity
@Table(name = "pf_tb")
@PrimaryKeyJoinColumn(name = "id")
public class PF extends Customer {
	private static final long serialVersionUID = 1L;

	public PF(String id, String document, String name, String email, String phone, List<Sale> sales) {
		super(id, document, name, email, phone, sales);
	}
}