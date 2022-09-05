package com.hekai.backend.repository;

import com.hekai.backend.entity.CourseCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseCategoryRepository extends JpaRepository<CourseCategory, Integer> {
    CourseCategory findCourseCategoryById(Integer id);
}