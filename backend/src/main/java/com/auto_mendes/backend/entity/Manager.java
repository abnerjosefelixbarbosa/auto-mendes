package com.auto_mendes.backend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
//@Entity
//@Table(name = "manager_tb")
//@PrimaryKeyJoinColumn(name = "id")
public class Manager extends Employee {
	private static final long serialVersionUID = 1L;
}