package com.org.auto_mendes_back_end_spring_boot_java.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.EmployeeRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.DeputyManager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Employee;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Manager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Saler;
import com.org.auto_mendes_back_end_spring_boot_java.enums.EmployeeType;
import com.org.auto_mendes_back_end_spring_boot_java.repositories.interfaces.IEmployeeRepository;

@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
class EmployeeControllerIT {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private IEmployeeRepository employeeRepository;
	@Autowired
	private EmployeeRequestDTO dto;
	@Autowired
	private Saler saler;
	@Autowired
	private Manager manager;
	@Autowired
	private DeputyManager deputyManager;
	private String matriculation = "";
	private String id = "";

	@BeforeEach
	void setUp() {
		//employeeRepository.deleteAll();
	}

	@AfterEach
	void tearDown() {
		employeeRepository.deleteAll();
	}
	
	@Test
	void shouldRegisterEmployeeAndReturnStatus201() throws Exception {
		dto.setCommission(new BigDecimal("40.00"));
		dto.setCpf("814.540.170-40");
		dto.setEmail("email5@gmail.com");
		dto.setEmployeeType(EmployeeType.SALER);
		dto.setMatriculation("5555555555");
		dto.setName("name5");
		dto.setSalary(new BigDecimal("400.00"));
		dto.setTelephone("(81) 95555-5555");
		
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

	@Test
	void shouldListEmployeesByPositionAndReturnStatus200() throws Exception {
		loadEmployees();

		mockMvc.perform(get("/api/employees/list-employees-by-position").queryParam("size", "10")
				.queryParam("employeeType", "MANAGER")).andExpect(status().isOk()).andDo(print());
	}
	
	@Test
	void shouldListEmployeesByMatriculationAndReturnStatus200() throws Exception {
		loadEmployees();

		mockMvc.perform(get("/api/employees/list-employees-by-matriculation").queryParam("size", "10")
				.queryParam("matriculation", matriculation)).andExpect(status().isOk()).andDo(print());
	}
	
	@Test
	void shouldUpdateEmployeeByIdAndReturnStatus200() throws Exception {
		loadEmployees();
		
		dto.setCommission(new BigDecimal("40.00"));
		dto.setCpf("814.540.170-40");
		dto.setEmail("email5@gmail.com");
		dto.setEmployeeType(EmployeeType.MANAGER);
		dto.setMatriculation("5555555555");
		dto.setName("name6");
		dto.setSalary(new BigDecimal("400.00"));
		dto.setTelephone("(81) 95555-5555");
		
		String json = objectMapper.writeValueAsString(dto);

		mockMvc.perform(put("/api/employees/update-employee-by-id").param("id", id).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isOk()).andDo(print());
	}

	void loadEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		
		Saler employee1 = saler;
		employee1.setId(UlidCreator.getUlid().toString());
		employee1.setCpf("737.697.500-47");
		employee1.setCommission(new BigDecimal("30.00"));
		employee1.setEmail("email1@gmail.com");
		employee1.setMatriculation("1111111111");
		employee1.setName("name1");
		employee1.setSalary(new BigDecimal("400.00"));
		employee1.setTelephone("(81) 91111-1111");
		
		Manager employee2 = manager;
		employee2.setCpf("320.434.700-19");
		employee2.setEmail("email2@gmail.com");
		employee2.setId(UlidCreator.getUlid().toString());
		employee2.setMatriculation("2222222222");
		employee2.setName("name2");
		employee2.setSalary(new BigDecimal("400.00"));
		employee2.setTelephone("(81) 92222-2222");
		
		DeputyManager employee3 = deputyManager;
		employee3.setCpf("297.232.130-87");
		employee3.setEmail("email3@gmail.com");
		employee3.setId(UlidCreator.getUlid().toString());
		employee3.setMatriculation("3333333333");
		employee3.setName("name3");
		employee3.setSalary(new BigDecimal("400.00"));
		employee3.setTelephone("(81) 93333-3333");
		
		Saler employee4 = saler;
		employee4.setId(UlidCreator.getUlid().toString());
		employee4.setCpf("460.731.410-25");
		employee4.setCommission(new BigDecimal("30.00"));
		employee4.setEmail("email4@gmail.com");
		employee4.setMatriculation("4444444444");
		employee4.setName("name4");
		employee4.setSalary(new BigDecimal("400.00"));
		employee4.setTelephone("(81) 94444-4444");

		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);
		employees.add(employee4);

		employees.forEach((item) -> employeeRepository.save(item));
		
		matriculation = employee2.getMatriculation();
		id = employee2.getId();
	}
}
