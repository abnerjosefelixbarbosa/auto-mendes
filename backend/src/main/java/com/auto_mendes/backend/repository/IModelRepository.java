package com.auto_mendes.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auto_mendes.backend.model.Model;

@Repository
public interface IModelRepository extends JpaRepository<Model, String> {
	boolean existsByName(String name);

	Optional<Model> findByName(String name);
}