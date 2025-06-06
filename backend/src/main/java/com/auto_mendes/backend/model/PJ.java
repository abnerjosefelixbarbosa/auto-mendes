package com.auto_mendes.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "pj_tb")
public class PJ extends Customer {
	private static final long serialVersionUID = 1L;
}