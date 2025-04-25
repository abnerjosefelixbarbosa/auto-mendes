package com.auto_mendes.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auto_mendes.backend.model.AssistantManager;

@Repository
public interface AssistantManagerRepository extends JpaRepository<AssistantManager, String> {
	boolean existsByEmailOrMatriculationOrPhone(String email, String matriculation, String phone);
}