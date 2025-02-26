package com.org.auto_mendes_back_end_spring_boot_java.mappers.interfaces;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.ModelRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.ModelResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Model;

@Mapper
public interface IModelMapper {
	@Mapping(target = "id", expression = "java(UlidCreator.getUlid().toString())")
	@Mapping(target = "mark", expression = "java(new Mark(null, dto.getMarkName(), null))")
	@Mapping(target = "vehicles", ignore = true)
	Model toModel(ModelRequestDTO dto);
	@Mapping(target = "markName", expression = "java(model.getMark().getName())")
	ModelResponseDTO toModelResponseDTO(Model model);
}
