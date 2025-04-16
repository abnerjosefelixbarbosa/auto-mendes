package com.auto_mendes.backend.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auto_mendes.backend.entity.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, String> {
	boolean existsByName(String name);

	Page<Model> findAllByNameContaining(String name, Pageable pageable);

	Optional<Model> findByName(String name);
}