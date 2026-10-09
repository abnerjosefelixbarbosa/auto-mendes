package com.concessionaria.backend.model.specification;

import org.springframework.data.jpa.domain.Specification;

import com.concessionaria.backend.model.entity.Customer;
import com.concessionaria.backend.model.entity.enums.CustomerType;

public class CustomerSpecification {
	private static Specification<Customer> byName(String name) {
		return (root, query, builder) -> {
			if (name == null) {
				return null;
			}

			return builder.like(builder.upper(root.get("name")), "%" + name.toUpperCase() + "%");
		};
	}

	private static Specification<Customer> byCustomerType(CustomerType customerType) {
		return (root, query, builder) -> {
			if (customerType == null) {
				return null;
			}

			return builder.equal(root.get("customerType"), customerType);
		};
	}

	public static Specification<Customer> filter(CustomerType customerType, String name) {
		return Specification.where(byCustomerType(customerType)).and(byName(name));
	}
}
