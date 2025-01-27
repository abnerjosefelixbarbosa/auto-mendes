package com.org.auto_mendes_back_end_spring_boot_java.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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
import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequest;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Employee;
import com.org.auto_mendes_back_end_spring_boot_java.enums.EmployeeType;
import com.org.auto_mendes_back_end_spring_boot_java.repositories.IEmployeeRepository;

@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
class EmployeeControllerTI {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private IEmployeeRepository employeeRepository;

	@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() {
		employeeRepository.deleteAll();
	}

	@Test
	void shouldRegisterEmployeeAndReturn201Status() throws Exception {
		loadEmployees();

		EmployeeRequest employeeRequest = new EmployeeRequest();
		employeeRequest.setBirthDate(LocalDate.of(1991, 01, 01));
		employeeRequest.setCommission(null);
		employeeRequest.setContact("(81) 94444-4444");
		employeeRequest.setCpf("790.518.510-90");
		employeeRequest.setEmail("email4@gmail.com");
		employeeRequest.setEmployeeType(EmployeeType.AssistantManager);
		employeeRequest.setMatriculation("4444444444");
		employeeRequest.setName("name4");

		String json = objectMapper.writeValueAsString(employeeRequest);

		mockMvc.perform(post("/employees/register-employee").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(json)).andExpect(MockMvcResultMatchers.status().isCreated())
				.andDo(print());
	}

	@Test
	void shouldRegisterEmployeeSalerAndReturn201Status() throws Exception {
		loadEmployees();

		EmployeeRequest employeeRequest = new EmployeeRequest();
		employeeRequest.setBirthDate(LocalDate.of(1991, 01, 01));
		employeeRequest.setCommission(BigDecimal.valueOf(20.00));
		employeeRequest.setContact("(81) 94444-4444");
		employeeRequest.setCpf("790.518.510-90");
		employeeRequest.setEmail("email4@gmail.com");
		employeeRequest.setEmployeeType(EmployeeType.Saler);
		employeeRequest.setMatriculation("4444444444");
		employeeRequest.setName("name4");

		String json = objectMapper.writeValueAsString(employeeRequest);

		mockMvc.perform(post("/employees/register-employee").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(json)).andExpect(MockMvcResultMatchers.status().isCreated())
				.andDo(print());
	}

	@Test
	void shouldRegisterEmployeeAndReturn400Status() throws Exception {
		loadEmployees();

		EmployeeRequest employeeRequest = new EmployeeRequest();
		employeeRequest.setBirthDate(LocalDate.of(1991, 01, 01));
		employeeRequest.setCommission(null);
		employeeRequest.setContact("(81) 94444-4444");
		employeeRequest.setCpf("790.518.510-90");
		employeeRequest.setEmail("email1@gmail.com");
		employeeRequest.setEmployeeType(EmployeeType.Manager);
		employeeRequest.setMatriculation("4444444444");
		employeeRequest.setName("name4");

		String json = objectMapper.writeValueAsString(employeeRequest);

		mockMvc.perform(post("/employees/register-employee").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(json))
				.andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andExpect(jsonPath("$.message").value("CPF, email, matrícula ou contato deve ser únicos"))
				.andDo(print());
	}

	void loadEmployees() {
		List<Employee> employees = List.of(
				new Employee(UlidCreator.getUlid().toString(), "name1", "908.918.120-24", LocalDate.of(1991, 01, 01),
						"email1@gmail.com", "(81) 91111-1111", "1111111111", null, EmployeeType.AssistantManager, null),
				new Employee(UlidCreator.getUlid().toString(), "name2", "158.009.470-82", LocalDate.of(1991, 02, 02),
						"email2@gmail.com", "(81) 92222-2222", "2222222222", null, EmployeeType.Manager, null),
				new Employee(UlidCreator.getUlid().toString(), "name3", "755.302.740-56", LocalDate.of(1991, 03, 03),
						"email3@gmail.com", "(81) 93333-3333", "3333333333", BigDecimal.valueOf(20.00),
						EmployeeType.Saler, null));
		
		employees.forEach((employee) -> employeeRepository.save(employee));
	}
}
