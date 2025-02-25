package com.org.auto_mendes_back_end_spring_boot_java.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/api/vehicles")
@Tag(name = "Veículos", description = "Operações relacionadas aos veículos")
public class VehicleController {
	
	
}