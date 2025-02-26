package com.org.auto_mendes_back_end_spring_boot_java.config;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.org.auto_mendes_back_end_spring_boot_java.mappers.interfaces.IEmployeeMapper;
import com.org.auto_mendes_back_end_spring_boot_java.mappers.interfaces.IMarkMapper;
import com.org.auto_mendes_back_end_spring_boot_java.mappers.interfaces.IModelMapper;
import com.org.auto_mendes_back_end_spring_boot_java.mappers.interfaces.IVehicleMapper;

@Configuration
public class BeansConfig {
	@Bean
	IMarkMapper getMarkMapper() {
		return Mappers.getMapper(IMarkMapper.class);
	}
	
	@Bean
	IModelMapper getModelMapper() {
		return Mappers.getMapper(IModelMapper.class);
	}
	
	@Bean
	IEmployeeMapper getIEmployeeMapper() {
		return Mappers.getMapper(IEmployeeMapper.class);
	}
	
	@Bean
	IVehicleMapper getIVehicleMapper() {
		return Mappers.getMapper(IVehicleMapper.class);
	}
}
