package com.auto_mendes.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auto_mendes.backend.model.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, String> {
	boolean existsByName(String name);

	Page<Brand> findAllByNameContaining(String name, Pageable pageable);
}