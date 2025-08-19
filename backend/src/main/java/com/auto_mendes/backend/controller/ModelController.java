package com.auto_mendes.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.auto_mendes.backend.dto.ModelRequestDTO;
import com.auto_mendes.backend.dto.ModelResponseDTO;
import com.auto_mendes.backend.service.IModelService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/models")
public class ModelController {
	@Autowired
    private IModelService modelService;
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(value = "/register-model", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ModelResponseDTO> registerModel(@RequestBody @Valid ModelRequestDTO dto) {
		ModelResponseDTO response = modelService.registeModel(dto);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@ResponseStatus(value = HttpStatus.OK)
	@PutMapping(value = "/update-model-by-id", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ModelResponseDTO> updateModelById(@RequestParam String id,
			@RequestBody @Valid ModelRequestDTO dto) {
		ModelResponseDTO response = modelService.updateModelById(id, dto);

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(value = "/list-models", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ModelResponseDTO>> listModels(Pageable pageable) {
		Page<ModelResponseDTO> page = modelService.listModels(pageable);

		return ResponseEntity.status(HttpStatus.OK).body(page.getContent());
	}
}