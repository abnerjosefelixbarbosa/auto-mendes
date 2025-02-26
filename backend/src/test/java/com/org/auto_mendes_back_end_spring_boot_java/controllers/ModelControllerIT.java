package com.org.auto_mendes_back_end_spring_boot_java.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.ModelRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Mark;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Model;
import com.org.auto_mendes_back_end_spring_boot_java.repositories.interfaces.IMarkRepository;
import com.org.auto_mendes_back_end_spring_boot_java.repositories.interfaces.IModelRepository;

@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
class ModelControllerIT {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private IModelRepository modelRepository;
	@Autowired
	private IMarkRepository markRepository;
	
	@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() {
		modelRepository.deleteAll();
		markRepository.deleteAll();
	}
	
	@Test
	void shouldRegisterModelAndReturnStatus201() throws Exception {
		loadModel();
		
		ModelRequestDTO dto = new ModelRequestDTO();
		dto.setName("name2");
		dto.setMarkName("name1");
		
		String json = objectMapper.writeValueAsString(dto);

		mockMvc.perform(post("/api/models/register-model").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isCreated()).andDo(print());
	}
	
	void loadModel() {
		Mark mark1 = new Mark();
		mark1.setId(UlidCreator.getUlid().toString());
		mark1.setName("name1");
		
		markRepository.save(mark1);
		
		Model model1 = new Model();
		model1.setId(UlidCreator.getUlid().toString());
		model1.setMark(mark1);
		model1.setName("name1");
		
		modelRepository.save(model1);
	}
}
