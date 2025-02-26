package com.org.auto_mendes_back_end_spring_boot_java.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.github.f4b6a3.ulid.UlidCreator;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.ModelRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.ModelResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Mark;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Model;
import com.org.auto_mendes_back_end_spring_boot_java.mappers.interfaces.IModelMapper;

@Component
public class ModelMapper implements IModelMapper {
	public Model toModel(ModelRequestDTO dto) {
		Mark mark = new Mark();
		mark.setName(dto.getMarkName());
		
		Model model = new Model();
		model.setId(UlidCreator.getUlid().toString());
		model.setMark(mark);
		
		BeanUtils.copyProperties(dto, model);
		
		return model;
	}

	@Override
	public ModelResponseDTO toModelResponseDTO(Model model) {
		ModelResponseDTO dto = new ModelResponseDTO();
		dto.setMarkName(model.getMark().getName());
		
		BeanUtils.copyProperties(model, dto);
		
		return dto;
	}
}
