package com.auto_mendes.backend.model;

import java.io.Serializable;
import java.util.List;

import com.auto_mendes.backend.enums.CustomerType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "customer_tb")
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id")
	private String id;
	@Column(name = "document", nullable = false,  unique = true, length = 20)
	private String document;
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	@Column(name = "email", nullable = false, unique = true, length = 100)
	private String email;
	@Column(name = "phone", nullable = false, unique = true, length = 30)
	private String phone;
	@Column(name = "customer_type", nullable = false)
	private CustomerType customerType;
	@OneToMany(mappedBy = "customer")
	private List<Sale> sales;
}