package com.org.auto_mendes_back_end_spring_boot_java.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.f4b6a3.ulid.UlidCreator;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.MarkRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.MarkResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Mark;
import com.org.auto_mendes_back_end_spring_boot_java.mappers.interfaces.IMarkMapper;

@Component
public class MarkMapper implements IMarkMapper {
	@Autowired
	private Mark mark;
	@Autowired
	private MarkResponseDTO markResponseDTO;
	
	public Mark toMark(MarkRequestDTO dto) {
		mark.setId(UlidCreator.getUlid().toString());
		
		BeanUtils.copyProperties(dto, mark);
		
		return mark;
	}

	public MarkResponseDTO toMarkResponseDTO(Mark mark) {
		BeanUtils.copyProperties(mark, markResponseDTO);
		
		return markResponseDTO;
	}
}
