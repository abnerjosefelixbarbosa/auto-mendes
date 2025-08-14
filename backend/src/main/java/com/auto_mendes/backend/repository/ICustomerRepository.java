package com.auto_mendes.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auto_mendes.backend.model.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, String> {
	
}