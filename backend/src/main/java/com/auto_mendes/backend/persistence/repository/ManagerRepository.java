package com.auto_mendes.backend.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auto_mendes.backend.persistence.entity.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, String> {
	boolean existsByEmailOrMatriculationOrPhone(String email, String matriculation, String phone);
}