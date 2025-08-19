package com.auto_mendes.backend.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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

import com.auto_mendes.backend.dto.VehicleRequestDTO;
import com.auto_mendes.backend.enums.BoxgearType;
import com.auto_mendes.backend.enums.VehicleType;
import com.auto_mendes.backend.model.Brand;
import com.auto_mendes.backend.model.Model;
import com.auto_mendes.backend.model.Vehicle;
import com.auto_mendes.backend.repository.IBrandRepository;
import com.auto_mendes.backend.repository.IModelRepository;
import com.auto_mendes.backend.repository.IVehicleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
class VehicleControllerIT {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private IBrandRepository brandRepository;
	@Autowired
	private IModelRepository modelRepository;
	@Autowired
	private IVehicleRepository vehicleRepository;

	@BeforeEach
	void setUp() {
		vehicleRepository.deleteAll();
		modelRepository.deleteAll();
		brandRepository.deleteAll();
	}

	@AfterEach
	void tearDown() {
		vehicleRepository.deleteAll();
		modelRepository.deleteAll();
		brandRepository.deleteAll();
	}

	@Test
	void shouldRegisterVehicleAndReturnStatus201() throws Exception {
		loadVehicleRegisted();

		VehicleRequestDTO vehicleRequestDTO = new VehicleRequestDTO();
		vehicleRequestDTO.setModelName("name2");
		vehicleRequestDTO.setPrice(new BigDecimal("1500.00"));
		vehicleRequestDTO.setTransmissionType(BoxgearType.AUTO);
		vehicleRequestDTO.setVehicleType(VehicleType.CAR);

		String json = objectMapper.writeValueAsString(vehicleRequestDTO);

		mockMvc.perform(post("/api/vehicles/register-vehicle").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isCreated()).andDo(print());
	}
	
	void loadVehicleRegisted() {
		Brand brand1 = new Brand();
		brand1.setName("name1");

		Brand brandSaved1 = brandRepository.save(brand1);

		Model model1 = new Model();
		model1.setName("name1");
		model1.setBrand(brandSaved1);

		Model model2 = new Model();
		model2.setName("name2");
		model2.setBrand(brandSaved1);

		Model modelSaved1 = modelRepository.save(model1);
		modelRepository.save(model2);

		Vehicle vehicle1 = new Vehicle();
		vehicle1.setModel(modelSaved1);
		vehicle1.setPrice(new BigDecimal("1500.00"));
		vehicle1.setBoxgearType(BoxgearType.AUTO);
		vehicle1.setVehicleType(VehicleType.CAR);

		vehicleRepository.save(vehicle1);
	}

	@Test
	void shouldUpdateVehicleByIdAndReturnStatus200() throws Exception {
		String id = loadVehicleUptadedWithId();

		VehicleRequestDTO vehicleRequestDTO = new VehicleRequestDTO();
		vehicleRequestDTO.setModelName("name2");
		vehicleRequestDTO.setPrice(new BigDecimal("2500.00"));
		vehicleRequestDTO.setTransmissionType(BoxgearType.AUTO);
		vehicleRequestDTO.setVehicleType(VehicleType.CAR);

		String json = objectMapper.writeValueAsString(vehicleRequestDTO);

		mockMvc.perform(put("/api/vehicles/update-vehicle-id").contentType(MediaType.APPLICATION_JSON).queryParam("id", id)
				.accept(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isOk()).andDo(print());
	}
	
	String loadVehicleUptadedWithId() {
		Brand brand1 = new Brand();
		brand1.setName("name1");

		Brand brandSaved1 = brandRepository.save(brand1);

		Model model1 = new Model();
		model1.setName("name1");
		model1.setBrand(brandSaved1);

		Model model2 = new Model();
		model2.setName("name2");
		model2.setBrand(brandSaved1);

		Model modelSaved1 = modelRepository.save(model1);
		modelRepository.save(model2);

		Vehicle vehicle1 = new Vehicle();
		vehicle1.setModel(modelSaved1);
		vehicle1.setPrice(new BigDecimal("1500.00"));
		vehicle1.setBoxgearType(BoxgearType.AUTO);
		vehicle1.setVehicleType(VehicleType.CAR);

		String id = vehicleRepository.save(vehicle1).getId();
		
		return id;
	}

	@Test
	void shouldListVehiclesAndReturnStatus200() throws Exception {
		loadVehicleListed();

		mockMvc.perform(get("/api/vehicles/list-vehicles")).andExpect(status().isOk()).andDo(print());
	}
	
	void loadVehicleListed() {
		Brand brand1 = new Brand();
		brand1.setName("name1");

		Brand brandSaved1 = brandRepository.save(brand1);

		Model model1 = new Model();
		model1.setName("name1");
		model1.setBrand(brandSaved1);

		Model model2 = new Model();
		model2.setName("name2");
		model2.setBrand(brandSaved1);

		Model modelSaved1 = modelRepository.save(model1);
		modelRepository.save(model2);

		Vehicle vehicle1 = new Vehicle();
		vehicle1.setModel(modelSaved1);
		vehicle1.setPrice(new BigDecimal("1500.00"));
		vehicle1.setBoxgearType(BoxgearType.AUTO);
		vehicle1.setVehicleType(VehicleType.CAR);
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setModel(modelSaved1);
		vehicle2.setPrice(new BigDecimal("1500.00"));
		vehicle2.setBoxgearType(BoxgearType.AUTO);
		vehicle2.setVehicleType(VehicleType.MOTORCYCLE);

		vehicleRepository.save(vehicle1);
		vehicleRepository.save(vehicle2);
	}
}
