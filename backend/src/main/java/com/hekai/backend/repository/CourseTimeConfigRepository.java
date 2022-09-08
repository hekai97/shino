package com.hekai.backend.repository;

import com.hekai.backend.entity.CourseTimeConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseTimeConfigRepository extends JpaRepository<CourseTimeConfig, Integer> {
}