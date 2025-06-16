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

import com.auto_mendes.backend.dto.BrandRequestDTO;
import com.auto_mendes.backend.model.Brand;
import com.auto_mendes.backend.repository.IBrandRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
class BrandControllerIT {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private IBrandRepository brandRepository;
	private String id = "";

	@BeforeEach
	void setUp() {
		brandRepository.deleteAll();
	}

	@AfterEach
	void tearDown() {
		brandRepository.deleteAll();
	}

	@Test
	void shouldRegisterBrandAndReturnStatus201() throws Exception {
		BrandRequestDTO brandRequestDTO = new BrandRequestDTO();
		brandRequestDTO.setName("name1");

		String json = objectMapper.writeValueAsString(brandRequestDTO);

		mockMvc.perform(post("/api/brands/register-brand").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isCreated()).andDo(print());
	}

	@Test
	void shouldUpdateBrandByIdAndReturnStatus200() throws Exception {
		loadBrand();

		BrandRequestDTO brandRequestDTO = new BrandRequestDTO();
		brandRequestDTO.setName("name2");

		String json = objectMapper.writeValueAsString(brandRequestDTO);

		mockMvc.perform(put("/api/brands/update-brand-by-id").queryParam("id", id)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	void shouldListBrandsAndReturnStatus200() throws Exception {
		loadBrand();

		mockMvc.perform(get("/api/brands/list-brands")).andExpect(status().isOk()).andDo(print());
	}

	void loadBrand() {
		Brand brand1 = new Brand();
		brand1.setName("name1");

		Brand savedBrand = brandRepository.save(brand1);

		id = savedBrand.getId();
	}
}
