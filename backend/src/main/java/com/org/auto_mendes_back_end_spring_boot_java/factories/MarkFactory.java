package com.org.auto_mendes_back_end_spring_boot_java.factories;

import org.springframework.stereotype.Component;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.MarkRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.MarkResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Mark;
import com.org.auto_mendes_back_end_spring_boot_java.factories.interfaces.IMarkFactory;

@Component
public class MarkFactory implements IMarkFactory {
	public Mark creatMark() {
		return new Mark();
	}
	
	public Mark creatMark(MarkRequestDTO dto) {
		return new Mark(dto);
	}
	
	public MarkRequestDTO creatMarkRequestDTO() {
		return new MarkRequestDTO();
	}
	
	public MarkResponseDTO creatMarkResponseDTO(Mark mark) {
		return new MarkResponseDTO(mark);
	}
}