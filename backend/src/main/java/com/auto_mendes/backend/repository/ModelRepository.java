package com.auto_mendes.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auto_mendes.backend.model.entity.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, String> {
	boolean existsByName(String name);
}