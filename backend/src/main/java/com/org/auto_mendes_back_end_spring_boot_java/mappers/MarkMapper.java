package com.org.auto_mendes_back_end_spring_boot_java.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.github.f4b6a3.ulid.UlidCreator;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.MarkRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.MarkResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Mark;

@Component
public class MarkMapper implements IMarkMapper {
	public Mark toMark(MarkRequestDTO dto) {
		Mark mark = new Mark();
		mark.setId(UlidCreator.getUlid().toString());
		
		BeanUtils.copyProperties(dto, mark);
		
		return mark;
	}

	public MarkResponseDTO toMarkResponseDTO(Mark mark) {
		MarkResponseDTO dto = new MarkResponseDTO();
		
		BeanUtils.copyProperties(mark, dto);
		
		return dto;
	}
}
