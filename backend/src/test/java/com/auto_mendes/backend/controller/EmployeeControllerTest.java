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
import com.auto_mendes.backend.entity.AssistantManager;
import com.auto_mendes.backend.entity.Manager;
import com.auto_mendes.backend.entity.Saler;
import com.auto_mendes.backend.enums.EmployeeType;
import com.auto_mendes.backend.repository.AssistantManagerRepository;
import com.auto_mendes.backend.repository.ManagerRepository;
import com.auto_mendes.backend.repository.SalerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
class EmployeeControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private ManagerRepository managerRepository;
	@Autowired
	private AssistantManagerRepository assistantManagerRepository;
	@Autowired
	private SalerRepository salerRepository;

	@BeforeEach
	void setUp() throws Exception {
		managerRepository.deleteAll();
		assistantManagerRepository.deleteAll();
		salerRepository.deleteAll();
	}

	@AfterEach
	void tearDown() throws Exception {
		managerRepository.deleteAll();
		assistantManagerRepository.deleteAll();
		salerRepository.deleteAll();
	}

	@Test
	void shouldRegisterEmployeeAndReturnStatus201() throws Exception {
		//loadEmployee();
		
		EmployeeRequestDTO request = new EmployeeRequestDTO("name1", "email1@gmail.com", "1111111111", "(81) 91111-1111",
				LocalDate.of(1999, 01, 01), EmployeeType.SALER, new BigDecimal("10.00"));
		
		String obj = objectMapper.writeValueAsString(request);

		mockMvc.perform(post("/api/employees/register-employee").contentType(MediaType.APPLICATION_JSON)
				.content(obj)).andExpect(MockMvcResultMatchers.status().isCreated())
				.andDo(print());
	}
	
	void loadEmployee() {
		Manager manager1 = new Manager();
		manager1.setBirthDate(LocalDate.of(1999, 01, 01));
		manager1.setEmail("email1@gmail.com");
		manager1.setMatriculation("1111111111");
		manager1.setName("name1");
		manager1.setPhone("(81) 91111-1111");
		
		AssistantManager assistantManager1 = new AssistantManager();
		assistantManager1.setBirthDate(LocalDate.of(1999, 02, 02));
		assistantManager1.setEmail("email2@gmail.com");
		assistantManager1.setMatriculation("2222222222");
		assistantManager1.setName("name2");
		assistantManager1.setPhone("(81) 92222-2222");
		
		Saler saler1 = new Saler();
		saler1.setBirthDate(LocalDate.of(1999, 03, 03));
		saler1.setEmail("email3@gmail.com");
		saler1.setMatriculation("3333333333");
		saler1.setName("name3");
		saler1.setPhone("(81) 93333-3333");
		saler1.setCommission(new BigDecimal("10.00"));
		
		managerRepository.save(manager1);
		
		assistantManagerRepository.save(assistantManager1);
		
		salerRepository.save(saler1);
	}
}
