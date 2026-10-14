package com.concessionaria.backend.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.concessionaria.backend.model.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>, JpaSpecificationExecutor<Customer> {
	boolean existsByNameOrDocumentOrEmailOrPhone(String name, String document, String email, String phone);

	Optional<Customer> findByDocument(String document);
}