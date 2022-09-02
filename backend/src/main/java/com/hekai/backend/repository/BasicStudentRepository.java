package com.hekai.backend.repository;

import com.hekai.backend.entity.BasicStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasicStudentRepository extends JpaRepository<BasicStudent, Integer> {
}