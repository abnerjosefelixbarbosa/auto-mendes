package com.auto_mendes.backend.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.math.BigDecimal;
import java.time.LocalDate;

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

import com.auto_mendes.backend.dto.request.EmployeeRequestDTO;
import com.auto_mendes.backend.enums.EmployeeType;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
class EmployeeControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void shouldRegisterEmployeeAndReturnStatus201() throws Exception {
		EmployeeRequestDTO request = new EmployeeRequestDTO("name1", "email1@gmail.com", "1111111111", "(81) 91111-1111",
				LocalDate.of(26, 03, 26), EmployeeType.MANAGER, new BigDecimal("10.00"));
		
		String obj = objectMapper.writeValueAsString(request);

		mockMvc.perform(post("/api/employees/register-employee").contentType(MediaType.APPLICATION_JSON)
				.content(obj)).andExpect(MockMvcResultMatchers.status().isCreated())
				.andDo(print());
	}
}
