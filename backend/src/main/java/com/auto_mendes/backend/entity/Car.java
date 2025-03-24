package com.auto_mendes.backend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Car extends Vehicle {
	private static final long serialVersionUID = 1L;
}