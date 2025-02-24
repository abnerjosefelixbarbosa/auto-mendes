package com.org.auto_mendes_back_end_spring_boot_java.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.ModelRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.ModelResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.services.IModelService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/models")
public class ModelController {
	@Autowired
	private IModelService modelService;
	
	@PostMapping(value = "/register-model")
	public ResponseEntity<ModelResponseDTO> registerModel(@Valid @RequestBody ModelRequestDTO dto) {
		ModelResponseDTO modelResponseDTO = modelService.registerModel(dto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(modelResponseDTO);
	}
}
