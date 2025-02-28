package com.org.auto_mendes_back_end_spring_boot_java.services.interfaces;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.ModelRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.ModelResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Model;

public interface IModelService {
	ModelResponseDTO registerModel(ModelRequestDTO dto);
	Model findByName(String name);
}