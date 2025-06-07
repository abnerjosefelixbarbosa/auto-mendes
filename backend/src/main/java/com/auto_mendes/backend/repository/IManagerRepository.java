package com.auto_mendes.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auto_mendes.backend.model.Manager;

@Repository
public interface IManagerRepository extends JpaRepository<Manager, String> {
	boolean existsByEmailOrMatriculationOrPhone(String email, String matriculation, String phone);
}