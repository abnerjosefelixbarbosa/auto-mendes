package com.auto_mendes.backend.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.auto_mendes.backend.dto.ModelRequestDTO;
import com.auto_mendes.backend.dto.ModelResponseDTO;
import com.auto_mendes.backend.model.Brand;
import com.auto_mendes.backend.model.Model;
import com.auto_mendes.backend.repository.IBrandRepository;
import com.auto_mendes.backend.repository.IModelRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.Valid;

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
	
	@BeforeEach
	void setUp(){
		modelRepository.deleteAll();
		brandRepository.deleteAll();
	}

	@AfterEach
	void tearDown()  {
		modelRepository.deleteAll();
		brandRepository.deleteAll();
	}
	
	@Test
	void shouldRegisterModelAndReturnStatus201() throws Exception {
		loadBrand();
		
		ModelRequestDTO modelRequestDTO = new ModelRequestDTO();
		modelRequestDTO.setName("name1");
		modelRequestDTO.setBrandName("name1");
		
		String json = objectMapper.writeValueAsString(modelRequestDTO);

		mockMvc.perform(post("/api/models/register-model").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isCreated()).andDo(print());
	}
	
	@Test
	void shouldUpdateModelByIdAndReturnStatus200() throws Exception {
		
	}

	@Test
	void shouldListModelsAndReturnStatus200() throws Exception {
		
	}
	
	void loadModel() {
		Brand brand1 = new Brand();
		brand1.setName("name1");
		
		Brand brandSaved1 = brandRepository.save(brand1);
		
		Model model1 = new Model();
		model1.setName("name1");
		model1.setBrand(brandSaved1);
		
		Model modelSaved1 = modelRepository.save(model1);
	}
	
	void loadBrand() {
		Brand brand1 = new Brand();
		brand1.setName("name1");
		
		Brand brandSaved1 = brandRepository.save(brand1);
	}
}