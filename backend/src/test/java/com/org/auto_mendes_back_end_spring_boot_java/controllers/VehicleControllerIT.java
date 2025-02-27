package com.org.auto_mendes_back_end_spring_boot_java.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.VehicleRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.enums.ExchangeType;
import com.org.auto_mendes_back_end_spring_boot_java.enums.VehicleType;
import com.org.auto_mendes_back_end_spring_boot_java.repositories.interfaces.IVehicleRepository;

@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
class VehicleControllerIT {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private IVehicleRepository vehicleRepository;
	@Autowired
	private VehicleRequestDTO dto;
	
	@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() {
		vehicleRepository.deleteAll();
	}
	
	@Test
	void shouldRegisterVehicleAndReturnStatus201() throws Exception {
		dto.setModelName("name1");
		dto.setColor("cor1");
		dto.setExchangeType(ExchangeType.Automatic);
		dto.setVehicleType(VehicleType.CAR);
		dto.setVehicleValue(new BigDecimal(3000.00));
		dto.setVehicleYear("2010");
		
		String json = objectMapper.writeValueAsString(dto);

		mockMvc.perform(post("/api/vehicles/register-vehicle").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isCreated()).andDo(print());
	}
}
