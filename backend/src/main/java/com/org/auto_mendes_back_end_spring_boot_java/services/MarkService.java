package com.org.auto_mendes_back_end_spring_boot_java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.MarkRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.MarkResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Mark;
import com.org.auto_mendes_back_end_spring_boot_java.exceptions.NotFoundException;
import com.org.auto_mendes_back_end_spring_boot_java.mappers.interfaces.IMarkMapper;
import com.org.auto_mendes_back_end_spring_boot_java.repositories.interfaces.IMarkRepository;
import com.org.auto_mendes_back_end_spring_boot_java.services.interfaces.IMarkService;
import com.org.auto_mendes_back_end_spring_boot_java.validations.interfaces.IMarkValidation;

import jakarta.transaction.Transactional;

@Service
public class MarkService implements IMarkService {
	@Autowired
	private IMarkRepository markRepository;
	@Autowired
	private IMarkMapper markMapper;
	@Autowired
	private IMarkValidation markValidation;

	@Transactional
	public MarkResponseDTO registerMark(MarkRequestDTO dto) {
		Mark mark = markMapper.toMark(dto);

		markValidation.validateMark(mark);

		mark = markRepository.save(mark);

		return markMapper.toMarkResponseDTO(mark);
	}

	public Mark findByName(String name) {
		return markRepository.findByName(name)
				.orElseThrow(() -> new NotFoundException("Nome da marca não encontrado"));
	}

	public MarkResponseDTO updateMarkById(String id, MarkRequestDTO dto) {
		Mark mark = markMapper.toMark(dto);

		markValidation.validateMark(mark);

		Mark markFound = markRepository.findById(id).orElseThrow(() -> new NotFoundException("Id não encontrado"));
		markFound.setName(mark.getName());

		mark = markRepository.save(markFound);

		return markMapper.toMarkResponseDTO(mark);
	}
}
