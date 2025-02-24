package com.org.auto_mendes_back_end_spring_boot_java.services;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.MarkRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.MarkResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Mark;

public interface IMarkService {
	Mark findByName(String name);

	MarkResponseDTO registerMark(MarkRequestDTO dto);
}