package com.auto_mendes.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auto_mendes.backend.model.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, String> {
	boolean existsByDocumentOrEmailOrPhone(String document, String email, String phone);

	Optional<Customer> findByDocument(String document);
}