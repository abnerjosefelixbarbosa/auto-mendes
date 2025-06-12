package com.auto_mendes.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auto_mendes.backend.model.Car;

@Repository
public interface ICarRepository extends JpaRepository<Car, String> {
	boolean existsByPlate(String plate);

	Optional<Car> findByIdAndModelName(String id, String modelName);
}