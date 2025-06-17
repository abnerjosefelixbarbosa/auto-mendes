package com.auto_mendes.backend.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.auto_mendes.backend.dto.ModelRequestDTO;
import com.auto_mendes.backend.model.Brand;
import com.auto_mendes.backend.model.Model;
import com.auto_mendes.backend.repository.IBrandRepository;
import com.auto_mendes.backend.repository.IModelRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
class ModelControllerIT {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private IBrandRepository brandRepository;
	@Autowired
	private IModelRepository modelRepository;
	private String id = "";

	@BeforeEach
	void setUp() {
		modelRepository.deleteAll();
		brandRepository.deleteAll();
	}

	@AfterEach
	void tearDown() {
		modelRepository.deleteAll();
		brandRepository.deleteAll();
	}

	@Test
	void shouldRegisterModelAndReturnStatus201() throws Exception {
		loadModel();

		ModelRequestDTO modelRequestDTO = new ModelRequestDTO();
		modelRequestDTO.setName("name2");
		modelRequestDTO.setBrandName("name1");

		String json = objectMapper.writeValueAsString(modelRequestDTO);

		mockMvc.perform(post("/api/models/register-model").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isCreated()).andDo(print());
	}

	@Test
	void shouldUpdateModelByIdAndReturnStatus200() throws Exception {
		loadModel();

		ModelRequestDTO modelRequestDTO = new ModelRequestDTO();
		modelRequestDTO.setName("name2");
		modelRequestDTO.setBrandName("name1");

		String json = objectMapper.writeValueAsString(modelRequestDTO);

		mockMvc.perform(put("/api/models/update-model-id").contentType(MediaType.APPLICATION_JSON).queryParam("id", id)
				.accept(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isOk()).andDo(print());
	}

	@Test
	void shouldListModelsAndReturnStatus200() throws Exception {
		loadModel();

		mockMvc.perform(get("/api/models/list-models")).andExpect(status().isOk()).andDo(print());
	}

	void loadModel() {
		Brand brand1 = new Brand();
		brand1.setName("name1");

		Brand brandSaved1 = brandRepository.save(brand1);

		Brand brand2 = new Brand();
		brand2.setName("name2");

		Brand brandSaved2 = brandRepository.save(brand2);

		Model model1 = new Model();
		model1.setName("name1");
		model1.setBrand(brandSaved1);

		Model modelSaved1 = modelRepository.save(model1);

		id = modelSaved1.getId();
	}
}