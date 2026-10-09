package com.concessionaria.backend.model.specification;

import org.springframework.data.jpa.domain.Specification;

import com.concessionaria.backend.model.entity.Employee;
import com.concessionaria.backend.model.entity.enums.EmployeeStatus;
import com.concessionaria.backend.model.entity.enums.EmployeeType;

public class EmployeeSpecification {
	private static Specification<Employee> byName(String name) {
		return (root, query, builder) -> {
			if (name == null) {
				return null;
			}

			return builder.like(builder.upper(root.get("name")), "%" + name.toUpperCase() + "%");
		};
	}

	private static Specification<Employee> byEmployeeStatus(EmployeeStatus employeeStatus) {
		return (root, query, builder) -> {
			if (employeeStatus == null) {
				return null;
			}

			return builder.equal(root.get("employeeStatus"), employeeStatus);
		};
	}

	private static Specification<Employee> byEmployeeType(EmployeeType employeeType) {
		return (root, query, builder) -> {
			if (employeeType == null) {
				return null;
			}

			return builder.equal(root.get("employeeType"), employeeType);
		};
	}

	public static Specification<Employee> filter(EmployeeStatus employeeStatus, EmployeeType employeeType,
			String name) {
		return Specification.where(byEmployeeStatus(employeeStatus)).and(byName(name))
				.and(byEmployeeType(employeeType));
	}
}
