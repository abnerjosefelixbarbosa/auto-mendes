package com.concessionaria.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.concessionaria.backend.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, String>, JpaSpecificationExecutor<Brand> {
	boolean existsByName(String name);

	Optional<Brand> findByNameIgnoreCase(String name);
}