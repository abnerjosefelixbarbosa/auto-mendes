package com.org.auto_mendes_back_end_spring_boot_java.entities;

import java.io.Serializable;
import java.util.List;

import com.org.auto_mendes_back_end_spring_boot_java.enums.CustomerType;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "customers")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String name;
	private String telephone;
	private String cnpj;
	private String cpf;
	private CustomerType customerType;
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private List<Sale> sales;
}
