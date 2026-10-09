package com.concessionaria.backend.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.concessionaria.backend.model.entity.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, String>, JpaSpecificationExecutor<Model>  {
	boolean existsByName(String name);
	
	Optional<Model> findByName(String name);
}
