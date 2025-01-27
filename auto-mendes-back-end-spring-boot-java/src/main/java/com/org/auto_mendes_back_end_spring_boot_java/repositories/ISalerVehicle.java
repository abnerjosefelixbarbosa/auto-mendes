package com.org.auto_mendes_back_end_spring_boot_java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.auto_mendes_back_end_spring_boot_java.entities.SalerVehicle;
import com.org.auto_mendes_back_end_spring_boot_java.entities.SalerVehicleId;

@Repository
public interface ISalerVehicle extends JpaRepository<SalerVehicle, SalerVehicleId> {

}