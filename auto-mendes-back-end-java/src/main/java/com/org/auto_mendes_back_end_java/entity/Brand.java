package com.org.auto_mendes_back_end_java.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "brands")
public class Brand implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", nullable = false)
	private String id;
	@Column(name = "name", nullable = false, unique = true)
	private String name;
}