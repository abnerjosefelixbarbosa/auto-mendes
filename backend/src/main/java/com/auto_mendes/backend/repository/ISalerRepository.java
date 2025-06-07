package com.auto_mendes.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auto_mendes.backend.model.Saler;

@Repository
public interface ISalerRepository extends JpaRepository<Saler, String> {
	boolean existsByEmailOrMatriculationOrPhone(String email, String matriculation, String phone);
}