package com.org.auto_mendes_back_end_java.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.f4b6a3.ulid.UlidCreator;
import com.org.auto_mendes_back_end_java.model.dto.EmployeeRequest;
import com.org.auto_mendes_back_end_java.model.entity.Employee;
import com.org.auto_mendes_back_end_java.model.entity.EmployeeType;
import com.org.auto_mendes_back_end_java.model.repository.IEmployeeRepository;

@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
class EmployeeControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private IEmployeeRepository employeeRepository;
	
	@BeforeEach
	void setup() {
		employeeRepository.deleteAll();
	}

	@AfterEach
	void tearDown() {
		employeeRepository.deleteAll();
	}

	@Test
	void registerEmployeeAndReturn201Status() throws Exception {
		EmployeeRequest request = new EmployeeRequest("name1",
				EmployeeType.SELLER,
				LocalDate.of(1991, 01, 01), 
			    "36716536477",
			    "24338131",
			    "email1@gmail.com",
			    "(81) 91111-1111");
		
		String json = objectMapper.writeValueAsString(request);
		
		mockMvc.perform(post("/api/employees/register-employee")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(json))
		.andExpect(MockMvcResultMatchers.status().isCreated())
		.andDo(print());
	}
	
	@Test
	void searchEmployeeAnd200Status() throws Exception {	
		loadEmployees();
		
		mockMvc.perform(get("/api/employees/search-employee")
				.queryParam("cpf", "36716536477"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(print());
	}
	
	@Test
	void listEmployeeByNameAnd200Status() throws Exception {	
		loadEmployees();
		
		mockMvc.perform(get("/api/employees/list-employee-by-name")
				.queryParam("name", "name")
				.queryParam("page", "0")
				.queryParam("size", "2"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(print());
	}
	
	void loadEmployees() {
		Employee employee1 = new Employee(UlidCreator.getUlid().toString(),
				"name1",
				EmployeeType.SELLER,
				LocalDate.of(1991, 01, 01),
				"36716536477",
				"24338131",
				"email1@gmail.com",
				"(81) 91111-1111");
		
		employeeRepository.save(employee1);
		
		/*
		Employee employee2 = new Employee(UlidCreator.getUlid().toString(),
				"name2",
				EmployeeType.SELLER,
				LocalDate.of(1991, 01, 01),
				"51514476029",
				"16493850",
				"email2@gmail.com",
				"(81) 91111-1112");
				
	    employeeRepository.save(employee2);
		*/	
	}
}