package com.org.auto_mendes_back_end_spring_boot_java.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.MarkRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.MarkResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.services.interfaces.IMarkService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/marks")
public class MarkController {
	@Autowired
	private IMarkService markService;
	
	@PostMapping(value = "/register-mark")
	public ResponseEntity<MarkResponseDTO> registerMark(@Valid @RequestBody MarkRequestDTO dto) {
		MarkResponseDTO markResponseDTO = markService.registerMark(dto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(markResponseDTO);
	}
}
