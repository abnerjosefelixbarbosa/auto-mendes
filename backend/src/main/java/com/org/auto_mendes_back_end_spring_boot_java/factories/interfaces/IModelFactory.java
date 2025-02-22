package com.org.auto_mendes_back_end_spring_boot_java.factories.interfaces;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.ModelRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Model;

public interface IModelFactory {
	Model createModel(ModelRequestDTO dto);
}