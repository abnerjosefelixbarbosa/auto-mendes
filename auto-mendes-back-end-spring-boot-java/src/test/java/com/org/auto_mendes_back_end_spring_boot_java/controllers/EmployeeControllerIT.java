package com.org.auto_mendes_back_end_spring_boot_java.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.f4b6a3.ulid.UlidCreator;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Employee;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Saler;
import com.org.auto_mendes_back_end_spring_boot_java.enums.EmployeeType;
import com.org.auto_mendes_back_end_spring_boot_java.repositories.EmployeeRepositoryInterface;

@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
class EmployeeControllerIT {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private EmployeeRepositoryInterface employeeRepository;

	// Dados para teste

	// EmployeeRequestDTO request = new EmployeeRequestDTO(null, null, null, null,
	// null, null, null, null);

	// EmployeeRequestDTO request = new EmployeeRequestDTO( "name1",
	// "814.540.170-40", "email1@gmail.com", "(81) 91111-1111", new
	// BigDecimal("400.00"), "1111111111", null, EmployeeType.Manager);

	// EmployeeRequestDTO request = new EmployeeRequestDTO("name2",
	// "814.540.170-40", "email2@gmail.com", "(81) 92222-2222", new
	// BigDecimal("400.00"), "2222222222", null, EmployeeType.DEPUTY_MANAGER);

	@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() {
		employeeRepository.deleteAll();
	}

	@Test
	void shouldRegisterEmployeeAndReturnStatus201() throws Exception {
		EmployeeRequestDTO dto = new EmployeeRequestDTO("name2", "814.540.170-40", "email2@gmail.com",
				"(81) 92222-2222", new BigDecimal("400.00"), "2222222222", null, EmployeeType.DEPUTY_MANAGER);

		String json = objectMapper.writeValueAsString(dto);

		mockMvc.perform(post("/api/employees/register-employee").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isCreated()).andDo(print());
	}

	@Test
	void shouldListEmployeesAndReturnStatus200() throws Exception {
		loadEmployees();

		mockMvc.perform(get("/api/employees/list-employees").queryParam("size", "10")).andExpect(status().isOk())
				.andDo(print());
	}

	void loadEmployees() {
		List<Employee> employees = new ArrayList<Employee>();

		employees.add(new Saler(UlidCreator.getUlid().toString(), "name1", "737.697.500-47", "email1@gmail.com", "(81) 91111-1111",
				new BigDecimal("400.00"), "1111111111", null, new BigDecimal("30.00")));

		employees.forEach((item) -> employeeRepository.save(item));
	}
}
