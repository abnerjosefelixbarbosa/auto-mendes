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

import com.auto_mendes.backend.dto.request.BrandRequestDTO;
import com.auto_mendes.backend.model.Brand;
import com.auto_mendes.backend.repository.BrandRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
class BrandControllerTest {
	@Autowired
	MockMvc mockMvc;
	@Autowired
	ObjectMapper objectMapper;
	@Autowired
	BrandRepository brandRepository;
	String brandName;
	String brandId;

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
		loadBrand();
		
		BrandRequestDTO request = new BrandRequestDTO("name3");

		String obj = objectMapper.writeValueAsString(request);

		mockMvc.perform(post("/api/brands/register-brand").contentType(MediaType.APPLICATION_JSON).content(obj))
				.andExpect(MockMvcResultMatchers.status().isCreated()).andDo(print());
	}
	
	@Test
	void shouldUpdateBrandByIdAndReturnStatus200() throws Exception {
		loadBrand();
		
		BrandRequestDTO request = new BrandRequestDTO("name3");

		String obj = objectMapper.writeValueAsString(request);

		mockMvc.perform(put("/api/brands/update-brand-by-id").queryParam("id", brandId).contentType(MediaType.APPLICATION_JSON).content(obj))
				.andExpect(MockMvcResultMatchers.status().isOk()).andDo(print());
	}
	
	@Test
	void shouldListBrandByNameAndReturnStatus200() throws Exception {
		loadBrand();

		mockMvc.perform(get("/api/brands/list-brand-by-name").queryParam("name", "name1"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andDo(print());
	}
	
	void loadBrand() {
		Brand brand1 = new Brand(null, "name1", null);
		
		Brand brand2 = new Brand(null, "name2", null);
		
		Brand brand = brandRepository.save(brand1);
		
		brandRepository.save(brand2);
		
		brandId = brand.getId();
	}
}