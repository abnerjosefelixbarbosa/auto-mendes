package com.auto_mendes.backend.persistence.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_tb")
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(nullable = false, unique = true, length = 20)
	private String document;
	@Column(nullable = false, length = 100)
	private String name;
	@Column(nullable = false, unique = true, length = 100)
	private String email;
	@Column(nullable = false, unique = true, length = 30)
	private String phone;
	@OneToMany(mappedBy = "customer")
	private List<Sale> sales;
}