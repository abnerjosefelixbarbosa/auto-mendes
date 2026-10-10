package com.concessionaria.backend.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.concessionaria.backend.model.entity.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String>, JpaSpecificationExecutor<Vehicle> {
	boolean existsByPlate(String plate);

	Optional<Vehicle> findByPlate(String plate);
}