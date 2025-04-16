package com.auto_mendes.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auto_mendes.backend.entity.Motorcycle;

@Repository
public interface MotorcycleRepository extends JpaRepository<Motorcycle, String> {
}