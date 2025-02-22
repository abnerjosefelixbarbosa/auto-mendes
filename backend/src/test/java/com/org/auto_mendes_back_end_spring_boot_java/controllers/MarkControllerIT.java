package com.org.auto_mendes_back_end_spring_boot_java.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.MarkRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Mark;
import com.org.auto_mendes_back_end_spring_boot_java.factories.interfaces.IMarkFactory;
import com.org.auto_mendes_back_end_spring_boot_java.repositories.interfaces.IMarkRepository;

@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
class MarkControllerIT {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private IMarkRepository markRepository;
	
	@BeforeEach
	void setUp() {
		//employeeRepository.deleteAll();
	}

	@AfterEach
	void tearDown() {
		markRepository.deleteAll();
	}
	
	@Test
	void shouldRegisterMarkAndReturnStatus201() throws Exception {
		loadMark();
		
		MarkRequestDTO dto = new MarkRequestDTO();
		dto.setName("name2");
		
		String json = objectMapper.writeValueAsString(dto);

		mockMvc.perform(post("/api/vehicles/register-mark").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isCreated()).andDo(print());
	}
	
	void loadMark() {
		List<Mark> marks = new ArrayList<Mark>();
		
		Mark mark1 = new Mark();
		mark1.setId(UlidCreator.getUlid().toString());
		mark1.setName("name1");
		
		marks.add(mark1);
		
		marks.forEach((item) -> markRepository.save(item));
	}
}
