package com.auto_mendes.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auto_mendes.backend.model.entity.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {
	Page<Vehicle> findAllByModelNameContaining(String model, Pageable pageable);
}