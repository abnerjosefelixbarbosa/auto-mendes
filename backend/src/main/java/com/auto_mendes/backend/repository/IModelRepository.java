package com.auto_mendes.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auto_mendes.backend.model.Model;

@Repository
public interface IModelRepository extends JpaRepository<Model, String> {

}