package com.org.auto_mendes_back_end_spring_boot_java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.EmployeeRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.MarkRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.ExceptionResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.DeputyManager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Manager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Mark;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Saler;

@Configuration
public class BeansConfig {
	@Bean
	ExceptionResponseDTO getResponseDTO() {
		return new ExceptionResponseDTO();
	}
	
	@Bean
	EmployeeRequestDTO getEmployeeRequestDTO() {
		return new EmployeeRequestDTO();
	}
	
	@Bean
	Saler getSaler() {
		return new Saler();
	}
	
	@Bean
	Manager getManager() {
		return new Manager();
	}
	
	@Bean
	DeputyManager getDeputyManager() {
		return new DeputyManager();
	}
	
	@Bean
	Mark getMark() {
		return new Mark();
	}
	
	@Bean
	MarkRequestDTO getMarkRequestDTO() {
		return new MarkRequestDTO();
	}
}
