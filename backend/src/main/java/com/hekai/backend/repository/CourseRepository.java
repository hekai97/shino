package com.hekai.backend.repository;

import com.hekai.backend.entity.Course;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    Course findCourseById(Integer id);
    Course findCourseByCourseNumber(String courseNumber);
    Page<Course> findCoursesByCourseCategoryId(Pageable pageable,Integer courseCategoryId);

    List<Course> findAllByCourseCategoryId(Integer categoryId);

    Page<Course> findCoursesByIdIn(Pageable pageable, List<Integer> courseIdList);
}