package com.org.auto_mendes_back_end_spring_boot_java.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.auto_mendes_back_end_spring_boot_java.entities.Motorcycle;

@Repository
public interface IMotorcycleRepository extends JpaRepository<Motorcycle, String>{

}
