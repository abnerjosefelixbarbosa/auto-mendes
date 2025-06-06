package com.auto_mendes.backend.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Motocycle extends Vehicle {
	private static final long serialVersionUID = 1L;
}