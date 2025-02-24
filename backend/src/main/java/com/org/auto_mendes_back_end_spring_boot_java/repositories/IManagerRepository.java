package com.org.auto_mendes_back_end_spring_boot_java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.auto_mendes_back_end_spring_boot_java.entities.Manager;

@Repository
public interface IManagerRepository extends JpaRepository<Manager, String> {

}
