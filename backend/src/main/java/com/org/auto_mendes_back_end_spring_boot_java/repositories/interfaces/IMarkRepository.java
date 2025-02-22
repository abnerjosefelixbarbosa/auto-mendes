package com.org.auto_mendes_back_end_spring_boot_java.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.auto_mendes_back_end_spring_boot_java.entities.Mark;

@Repository
public interface IMarkRepository extends JpaRepository<Mark, String> {
	boolean existsByName(String name);
}