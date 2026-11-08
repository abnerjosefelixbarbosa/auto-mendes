package com.concessionaria.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.concessionaria.backend.entity.Model;

public interface ModelService {
	Model registerModel(Model model);

	Model updateModelById(String id, Model model);

	Model findModelById(String id);

	Page<Model> listModels(String name, Pageable pageable);

	Model findModelByName(String name);
}