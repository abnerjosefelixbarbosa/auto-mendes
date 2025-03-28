package com.auto_mendes.backend.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auto_mendes.backend.persistence.entity.Saler;

@Repository
public interface SalerRepository extends JpaRepository<Saler, String> {
	boolean existsByEmailOrMatriculationOrPhone(String email, String matriculation, String phone);
}