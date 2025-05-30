package com.auto_mendes.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auto_mendes.backend.model.Brand;

@Repository
public interface IBrandRepository extends JpaRepository<Brand, String> {
	boolean existsByName(String name);
}