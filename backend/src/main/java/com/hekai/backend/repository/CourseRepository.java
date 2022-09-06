package com.hekai.backend.repository;

import com.hekai.backend.entity.Course;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    Course findCourseById(Integer id);
    Course findCourseByCourseNumber(String courseNumber);
    Page<Course> findCoursesByCourseCategoryId(Pageable pageable,Integer courseCategoryId);

}