package com.auto_mendes.backend.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.auto_mendes.backend.dto.request.VehicleRequestDTO;
import com.auto_mendes.backend.enums.TransmissionType;
import com.auto_mendes.backend.enums.VehicleType;
import com.auto_mendes.backend.repository.BrandRepository;
import com.auto_mendes.backend.repository.CarRepository;
import com.auto_mendes.backend.repository.ModelRepository;
import com.auto_mendes.backend.repository.MotorcycleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
public class VehicleControllerTest {
	@Autowired
	MockMvc mockMvc;
	@Autowired
	ObjectMapper objectMapper;
	@Autowired
	ModelRepository modelRepository;
	@Autowired
	CarRepository carRepository;
	@Autowired
	MotorcycleRepository motorcycleRepository;
	@Autowired
	BrandRepository brandRepository;
	String id;

	@BeforeEach
	void setUp() {
		carRepository.deleteAll();
		motorcycleRepository.deleteAll();
		modelRepository.deleteAll();
	}

	@AfterEach
	void tearDown() {
		carRepository.deleteAll();
		motorcycleRepository.deleteAll();
		modelRepository.deleteAll();
	}

	@Test
	void shouldRegisterVehicleAndReturnStatus201() throws Exception {
		loadVehicle();

		VehicleRequestDTO request = new VehicleRequestDTO(null, TransmissionType.AUTO, new BigDecimal("1500.00"),
				"name1", VehicleType.CAR);

		String obj = objectMapper.writeValueAsString(request);

		mockMvc.perform(post("/api/vehicles/register-vehicle").contentType(MediaType.APPLICATION_JSON).content(obj))
				.andExpect(MockMvcResultMatchers.status().isCreated()).andDo(print());
	}

	@Test
	void shouldUpdateVehicleByIdAndReturnStatus200() throws Exception {
		loadVehicle();

		VehicleRequestDTO request = new VehicleRequestDTO(null, TransmissionType.AUTO, new BigDecimal("1500.00"),
				"name1", VehicleType.CAR);

		String obj = objectMapper.writeValueAsString(request);

		mockMvc.perform(put("/api/vehicles/update-vehicle-by-id").queryParam("id", id)
				.contentType(MediaType.APPLICATION_JSON).content(obj)).andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(print());
	}

	@Test
	void shouldListVehicleByModelAndReturnStatus200() throws Exception {
		loadVehicle();

		mockMvc.perform(get("/api/vehicles/list-vehicle-by-model").queryParam("model", "name")).andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(print());
	}

	void loadVehicle() {
		/*
		Brand brand1 = new Brand(null, "name1", null);

		brand1 = brandRepository.save(brand1);

		Model model1 = new Model(null, "name1", brand1, null);

		model1 = modelRepository.save(model1);

		Car car1 = new Car(null, null, TransmissionType.AUTO, new BigDecimal("1500.00"), model1, null);

		car1 = carRepository.save(car1);
		
		Car car2 = new Car(null, null, TransmissionType.AUTO, new BigDecimal("1500.00"), model1, null);

		car2 = carRepository.save(car2);

		id = car1.getId();
		*/
	}
}