package com.auto_mendes.backend.entity;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity
//@Table(name = "customer_tb")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String document;
	private String name;
	private String email;
	private String phone;
	private List<Sale> sales;
}