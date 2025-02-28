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
import com.github.f4b6a3.ulid.UlidCreator;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.VehicleRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Car;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Mark;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Model;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Motorcycle;
import com.org.auto_mendes_back_end_spring_boot_java.enums.ExchangeType;
import com.org.auto_mendes_back_end_spring_boot_java.enums.VehicleType;
import com.org.auto_mendes_back_end_spring_boot_java.repositories.interfaces.IMarkRepository;
import com.org.auto_mendes_back_end_spring_boot_java.repositories.interfaces.IModelRepository;
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
	private IModelRepository modelRepository;
	@Autowired
	private IMarkRepository markRepository;
	
	@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() {
		vehicleRepository.deleteAll();
		modelRepository.deleteAll();
	}
	
	@Test
	void shouldRegisterVehicleAndReturnStatus201() throws Exception {
		loadVehicles();
		
		VehicleRequestDTO dto = new VehicleRequestDTO();
		dto.setModelName("name1");
		dto.setColor("cor1");
		dto.setExchangeType(ExchangeType.Automatic);
		dto.setVehicleType(VehicleType.CAR);
		dto.setVehicleValue(new BigDecimal("3000.00"));
		dto.setVehicleYear("2010");
		dto.setModelName("nome1");
		
		String json = objectMapper.writeValueAsString(dto);

		mockMvc.perform(post("/api/vehicles/register-vehicle").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isCreated()).andDo(print());
	}
	
	
	void loadVehicles() {
		Mark mark1 = new Mark();
		mark1.setId(UlidCreator.getUlid().toString());
		mark1.setName("nome1");
		
		markRepository.save(mark1);
		
		Model model1 = new Model();
		model1.setId(UlidCreator.getUlid().toString());
		model1.setMark(mark1);
		model1.setName("nome1");
		
		modelRepository.save(model1);
		
		Car car1 = new Car();
		car1.setColor("cor1");
		car1.setExchangeType(ExchangeType.Automatic);
		car1.setId(UlidCreator.getUlid().toString());
		car1.setModel(model1);
		car1.setVehicleValue(new BigDecimal("2500.00"));
		car1.setVehicleYear("2010");
		
		vehicleRepository.save(car1);
		
		Motorcycle motorcycle1 = new Motorcycle();
		motorcycle1.setColor("cor1");
		motorcycle1.setExchangeType(ExchangeType.DCT);
		motorcycle1.setId(UlidCreator.getUlid().toString());
		motorcycle1.setModel(model1);
		motorcycle1.setVehicleValue(new BigDecimal("2500.00"));
		motorcycle1.setVehicleYear("2010");
		
		vehicleRepository.save(motorcycle1);
	}
}
