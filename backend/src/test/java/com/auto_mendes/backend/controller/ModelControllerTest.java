package com.auto_mendes.backend.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

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

import com.auto_mendes.backend.dto.request.ModelRequestDTO;
import com.auto_mendes.backend.model.Brand;
import com.auto_mendes.backend.model.Model;
import com.auto_mendes.backend.repository.BrandRepository;
import com.auto_mendes.backend.repository.ModelRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
public class ModelControllerTest {
	@Autowired
	MockMvc mockMvc;
	@Autowired
	ObjectMapper objectMapper;
	@Autowired
	ModelRepository modelRepository;
	@Autowired
	BrandRepository brandRepository;
	String modelId;

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

		ModelRequestDTO request = new ModelRequestDTO("name2", "name1");

		String obj = objectMapper.writeValueAsString(request);

		mockMvc.perform(post("/api/models/register-model").contentType(MediaType.APPLICATION_JSON).content(obj))
				.andExpect(MockMvcResultMatchers.status().isCreated()).andDo(print());
	}

	@Test
	void shouldUpdateModelByIdAndReturnStatus200() throws Exception {
		loadModel();

		ModelRequestDTO request = new ModelRequestDTO("name2", "name1");

		String obj = objectMapper.writeValueAsString(request);

		mockMvc.perform(put("/api/models/update-model-by-id").queryParam("id", modelId)
				.contentType(MediaType.APPLICATION_JSON).content(obj))
				.andExpect(MockMvcResultMatchers.status().isOk()).andDo(print());
	}
	
	@Test
	void shouldListModelByNameAndReturnStatus200() throws Exception {
		loadModel();

		mockMvc.perform(get("/api/models/list-model-by-name").queryParam("name", "name1"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andDo(print());
	}

	void loadModel() {
		Brand brand1 = new Brand(null, "name1", null);

		Brand brand = brandRepository.save(brand1);

		Model model1 = new Model(null, "name1", brand, null);
		
		Model model2 = new Model(null, "name2", brand, null);

		Model model = modelRepository.save(model1);
		
		modelRepository.save(model2);

		modelId = model.getId();
	}
}