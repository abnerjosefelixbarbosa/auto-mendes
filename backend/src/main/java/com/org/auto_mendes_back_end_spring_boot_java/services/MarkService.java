package com.org.auto_mendes_back_end_spring_boot_java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.auto_mendes_back_end_spring_boot_java.entities.Mark;
import com.org.auto_mendes_back_end_spring_boot_java.repositories.interfaces.IMarkRepository;
import com.org.auto_mendes_back_end_spring_boot_java.services.interfaces.IMarkService;

@Service
public class MarkService implements IMarkService {
	@Autowired
	private IMarkRepository markRepository;
	
	public Mark save(Mark mark) {
		return markRepository.save(mark);
	}
}
