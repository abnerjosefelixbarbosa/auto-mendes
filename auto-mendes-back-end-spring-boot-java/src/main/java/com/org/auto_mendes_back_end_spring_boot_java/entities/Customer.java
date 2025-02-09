package com.org.auto_mendes_back_end_spring_boot_java.entities;

import java.io.Serializable;
import java.util.List;

import com.org.auto_mendes_back_end_spring_boot_java.enums.CustomerType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	private String id;
	@Column(nullable = false, unique = true)
	private String name;
	@Column(nullable = false, unique = true)
	private String telephone;
	@Column(length = 18)
	private String cnpj;
	@Column(length = 14)
	private String cpf;
	@Column(nullable = false)
	private CustomerType customerType;
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private List<Sale> sales;
}
