package com.org.auto_mendes_back_end_spring_boot_java.mappers.interfaces;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.MarkRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.MarkResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Mark;

@Mapper
public interface IMarkMapper {
	@Mapping(target = "id", expression = "java(UlidCreator.getUlid().toString())")
	@Mapping(target = "models", ignore = true)
	Mark toMark(MarkRequestDTO dto);

	MarkResponseDTO toMarkResponseDTO(Mark mark);
}