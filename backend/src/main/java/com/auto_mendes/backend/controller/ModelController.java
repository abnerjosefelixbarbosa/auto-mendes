package com.auto_mendes.backend.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auto_mendes.backend.dto.request.ModelRequestDTO;
import com.auto_mendes.backend.dto.response.ModelResponseDTO;
import com.auto_mendes.backend.service.ModelService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/models")
@RequiredArgsConstructor
public class ModelController {
	private final ModelService modelService;

	@PostMapping(value = "/register-model")
	public ResponseEntity<ModelResponseDTO> registerModel(@Valid @RequestBody ModelRequestDTO dto) {
		ModelResponseDTO response = modelService.registerModel(dto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PutMapping(value = "/update-model-by-id")
	public ResponseEntity<ModelResponseDTO> updateModelById(@RequestParam String id, @Valid @RequestBody ModelRequestDTO dto) {
		ModelResponseDTO response = modelService.updateModelById(id, dto);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping(value = "/list-model-by-name")
	public ResponseEntity<Page<ModelResponseDTO>> listModelByName(@RequestParam String name, Pageable pageable) {
		Page<ModelResponseDTO> page = modelService.listModelByName(name, pageable);
		
		return ResponseEntity.status(HttpStatus.OK).body(page);
	}
}