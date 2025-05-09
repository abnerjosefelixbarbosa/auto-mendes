package com.auto_mendes.backend.model;

import java.util.List;

import com.auto_mendes.backend.enums.CustomerType;

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
@Table(name = "pj_tb")
@PrimaryKeyJoinColumn(name = "id")
public class PJ extends Customer {
	private static final long serialVersionUID = 1L;

	public PJ(String id, String document, String name, String email, String phone, CustomerType customerType, List<Sale> sales) {
		super(id, document, name, email, phone, customerType, sales);
	}
}