package com.org.auto_mendes_back_end_spring_boot_java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.ModelRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.VehicleRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.MarkResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Employee;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Mark;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Model;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Vehicle;

@Configuration
public class BeansConfig {
	@Bean
	Mark createMark() {
		return new Mark();
	}
	
	@Bean
	Model createModel() {
		return new Model();
	}
	
	@Bean
	Employee createEmployee() {
		return new Employee();
	}
	
	@Bean
	Vehicle createVehicle() {
		return new Vehicle();
	}
	
	@Bean
	VehicleRequestDTO createVehicleRequestDTO() {
		return new VehicleRequestDTO(); 
	}
	
	@Bean
	ModelRequestDTO createModelRequestDTO() {
		return new ModelRequestDTO();
	}
	
	@Bean
	MarkResponseDTO createMarkResponseDTO() {
		return new MarkResponseDTO();
	}
}
