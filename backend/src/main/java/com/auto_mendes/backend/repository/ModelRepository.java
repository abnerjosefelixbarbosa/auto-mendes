package com.auto_mendes.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auto_mendes.backend.model.entity.Model;

public interface ModelRepository extends JpaRepository<Model, String> {
}