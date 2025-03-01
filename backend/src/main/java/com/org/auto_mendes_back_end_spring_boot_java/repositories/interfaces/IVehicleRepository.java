package com.org.auto_mendes_back_end_spring_boot_java.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.auto_mendes_back_end_spring_boot_java.entities.Vehicle;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, String> {	
	//@Query(value = "SELECT v.id, v.plate, v.color, v.vehicle_value, v.vehicle_year, v.exchange_type, m.name"
	//		+ " FROM vehicles v JOIN models m"
	//		+ " ON v.model_id = m.id", nativeQuery = true)
	//Page<VehicleResponseDTO> listVehicle(Pageable pageable);
}