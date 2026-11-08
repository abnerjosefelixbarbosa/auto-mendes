package com.concessionaria.backend.specification;

import org.springframework.data.jpa.domain.Specification;

import com.concessionaria.backend.entity.Brand;

public class BrandSpecification {
	private static Specification<Brand> byName(String name) {
		return (root, query, builder) -> {
			if (name == null) {
				return null;
			}

			return builder.like(builder.upper(root.get("name")), "%" + name.toUpperCase() + "%");
		};
	}

	public static Specification<Brand> filter(String name) {
		return Specification.where(byName(name));
	}
}
