package com.auto_mendes.backend.entity;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private List<Model> models;
}