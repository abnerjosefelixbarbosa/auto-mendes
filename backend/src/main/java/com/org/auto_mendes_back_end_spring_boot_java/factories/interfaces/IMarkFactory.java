package com.org.auto_mendes_back_end_spring_boot_java.factories.interfaces;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.MarkRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.MarkResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Mark;

public interface IMarkFactory {
	Mark creatMark(MarkRequestDTO dto);
	MarkResponseDTO creatMarkResponseDTO(Mark mark);
}