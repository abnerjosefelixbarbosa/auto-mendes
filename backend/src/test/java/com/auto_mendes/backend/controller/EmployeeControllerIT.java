package com.auto_mendes.backend.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.auto_mendes.backend.dto.EmployeeRequestDTO;
import com.auto_mendes.backend.enums.EmployeeType;
import com.auto_mendes.backend.model.Manager;
import com.auto_mendes.backend.model.Saler;
import com.auto_mendes.backend.model.Submanager;
import com.auto_mendes.backend.repository.IManagerRepository;
import com.auto_mendes.backend.repository.ISalerRepository;
import com.auto_mendes.backend.repository.ISubmanagerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
class EmployeeControllerIT {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private IManagerRepository managerRepository;
	@Autowired
	private ISubmanagerRepository submanagerRepository;
	@Autowired
	private ISalerRepository salerRepository;

	@BeforeEach
	void setUp() {
		managerRepository.deleteAll();
		submanagerRepository.deleteAll();
		salerRepository.deleteAll();
	}

	@AfterEach
	void tearDown() {
		managerRepository.deleteAll();
		submanagerRepository.deleteAll();
		salerRepository.deleteAll();
	}
	
	@Test
	void shouldRegisterEmployeeAndReturnStatus201() throws Exception {
		loadEmployeeRegister();
		
		EmployeeRequestDTO employeeRequestDTO = new EmployeeRequestDTO();
		employeeRequestDTO.setBirthDate(LocalDate.of(1992, 02, 02));
		employeeRequestDTO.setCommission(new BigDecimal("100.00"));
		employeeRequestDTO.setEmail("email2@gmail.com");
		employeeRequestDTO.setEmployeeType(EmployeeType.MANAGER);
		employeeRequestDTO.setMatriculation("2222222222");
		employeeRequestDTO.setName("name2");
		employeeRequestDTO.setPhone("(81) 92222-2222");
		
		String json = objectMapper.writeValueAsString(employeeRequestDTO);
		
		mockMvc.perform(post("/api/employees/register-employee").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isCreated()).andDo(print());
	}
	
	private void loadEmployeeRegister() {
		Manager employee1 = new Manager();
		employee1.setBirthDate(LocalDate.of(1991, 01, 01));
		employee1.setEmail("email1@gmail.com");
		employee1.setEmployeeType(EmployeeType.MANAGER);
		employee1.setMatriculation("1111111111");
		employee1.setName("name1");
		employee1.setPhone("(81) 91111-1111");
		
		managerRepository.save(employee1);
	}
	
	@Test
	void shouldUpdateEmployeeByIdAndReturnStatus200() throws Exception {
		String id = loadEmployeeUpdatedWithId();

		EmployeeRequestDTO employeeRequestDTO = new EmployeeRequestDTO();
		employeeRequestDTO.setBirthDate(LocalDate.of(1992, 02, 02));
		employeeRequestDTO.setCommission(new BigDecimal("100.00"));
		employeeRequestDTO.setEmail("email2@gmail.com");
		employeeRequestDTO.setEmployeeType(EmployeeType.MANAGER);
		employeeRequestDTO.setMatriculation("2222222222");
		employeeRequestDTO.setName("name2");
		employeeRequestDTO.setPhone("(81) 92222-2222");

		String json = objectMapper.writeValueAsString(employeeRequestDTO);

		mockMvc.perform(put("/api/employees/update-employee-id").contentType(MediaType.APPLICATION_JSON).queryParam("id", id)
				.accept(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isOk()).andDo(print());
	}
	
	private String loadEmployeeUpdatedWithId() {
		Manager employee1 = new Manager();
		employee1.setBirthDate(LocalDate.of(1991, 01, 01));
		employee1.setEmail("email1@gmail.com");
		employee1.setEmployeeType(EmployeeType.MANAGER);
		employee1.setMatriculation("1111111111");
		employee1.setName("name1");
		employee1.setPhone("(81) 91111-1111");
		
		String id = managerRepository.save(employee1).getId();
		
		return id;
	}

	@Test
	void shouldListEmployeesAndReturnStatus200() throws Exception {
		loadEmployeeListed();
		
		mockMvc.perform(get("/api/employees/list-employees")).andExpect(status().isOk()).andDo(print());
	}
	
	private void loadEmployeeListed() {
		Manager employee1 = new Manager();
		employee1.setBirthDate(LocalDate.of(1991, 01, 01));
		employee1.setEmail("email1@gmail.com");
		employee1.setEmployeeType(EmployeeType.MANAGER);
		employee1.setMatriculation("1111111111");
		employee1.setName("name1");
		employee1.setPhone("(81) 91111-1111");
		
		Submanager employee2 = new Submanager();
		employee2.setBirthDate(LocalDate.of(1992, 02, 02));
		employee2.setEmail("email2@gmail.com");
		employee2.setEmployeeType(EmployeeType.SUBMANAGER);
		employee2.setMatriculation("2222222222");
		employee2.setName("name2");
		employee2.setPhone("(81) 92222-2222");
		
		Saler employee3 = new Saler();
		employee3.setBirthDate(LocalDate.of(1993, 03, 03));
		employee3.setEmail("email3@gmail.com");
		employee3.setEmployeeType(EmployeeType.SALER);
		employee3.setMatriculation("3333333333");
		employee3.setName("name3");
		employee3.setPhone("(81) 93333-3333");
		employee3.setCommission(new BigDecimal("1500.00"));
		
		managerRepository.save(employee1);
		submanagerRepository.save(employee2);
		salerRepository.save(employee3);
	}
}
