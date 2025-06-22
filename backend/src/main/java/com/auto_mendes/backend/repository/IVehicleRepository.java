package com.auto_mendes.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auto_mendes.backend.model.Vehicle;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, String> {
	boolean existsByPlate(String plate);
}