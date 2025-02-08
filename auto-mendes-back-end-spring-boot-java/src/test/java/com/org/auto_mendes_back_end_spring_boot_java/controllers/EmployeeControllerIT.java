package com.org.auto_mendes_back_end_spring_boot_java.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.enums.EmployeeType;

@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
class EmployeeControllerIT {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;

	@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() {
	}

	@Test
	void shouldRegisterEmployeeAndReturnStatus201() throws Exception {
		EmployeeRequestDTO request = new EmployeeRequestDTO(
				"name1",
				"814.540.170-40",
				"email1@gmail.com",
				"(81) 91111-1111",
				new BigDecimal("400.00"),
				"1111111111",
				null,
				EmployeeType.Manager
		);

		String json = objectMapper.writeValueAsString(request);
		
		mockMvc.perform(post("/api/employees/register-employee")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(json))
		.andExpect(status().isCreated())
		.andDo(print());
	}
	
	@Test
	void shouldRegisterEmployeeAndReturnStatus400() throws Exception {
		EmployeeRequestDTO request = new EmployeeRequestDTO(
				"name1",
				"814.540.170-40",
				"email1@gmail.com",
				"(81) 91111-1111",
				new BigDecimal("400.0"),
				"1111111111",
				null,
				EmployeeType.Manager
		);

		String json = objectMapper.writeValueAsString(request);
		
		mockMvc.perform(post("/api/employees/register-employee")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(json))
		.andExpect(status().isBadRequest())
		.andDo(print());
	}
	
	@Test
	void shouldRegisterEmployeeSalerAndReturnStatus201() throws Exception {
		EmployeeRequestDTO request = new EmployeeRequestDTO(
				"name1",
				"814.540.170-40",
				"email1@gmail.com",
				"(81) 91111-1111",
				new BigDecimal("400.00"),
				"1111111111",
				new BigDecimal("150.00"),
				EmployeeType.Saler
		);

		String json = objectMapper.writeValueAsString(request);
		
		mockMvc.perform(post("/api/employees/register-employee")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(json))
		.andExpect(status().isCreated())
		.andDo(print());
	}
	
	@Test
	void shouldRegisterEmployeeSalerAndReturnStatus400() throws Exception {
		EmployeeRequestDTO request = new EmployeeRequestDTO(
				"name1",
				"814.540.170-40",
				"email1@gmail.com",
				"(81) 91111-1111",
				new BigDecimal("400.0"),
				"1111111111",
				new BigDecimal("150.0"),
				EmployeeType.Saler
		);

		String json = objectMapper.writeValueAsString(request);
		
		mockMvc.perform(post("/api/employees/register-employee")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(json))
		.andExpect(status().isBadRequest())
		.andDo(print());
	}
}
