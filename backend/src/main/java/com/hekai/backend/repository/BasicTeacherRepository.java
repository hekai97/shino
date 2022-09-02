package com.hekai.backend.repository;

import com.hekai.backend.entity.BasicTeacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasicTeacherRepository extends JpaRepository<BasicTeacher, Integer> {
}