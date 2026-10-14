package com.concessionaria.backend.model.specification;

import org.springframework.data.jpa.domain.Specification;

import com.concessionaria.backend.model.entity.Model;

public class ModelSpecification {
	private static Specification<Model> byName(String name) {
		return (root, query, builder) -> {
			if (name == null) {
				return null;
			}

			return builder.like(builder.upper(root.get("name")), "%" + name.toUpperCase() + "%");
		};
	}

	public static Specification<Model> filter(String name) {
		return Specification.where(byName(name));
	}
}
