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
	@Column(name = "id")
	private String id;
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	@Column(name = "cpf", length = 20)
	private String cpf;
	@Column(name = "birth_date")
	private String birthDate;
	@Column(name = "cnpj", length = 20)
	private String cnpj;
	@Column(name = "customer_type", nullable = false)
	private CustomerType customerType;
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private List<Sale> sales;
}
