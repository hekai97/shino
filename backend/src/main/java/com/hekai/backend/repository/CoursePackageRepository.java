package com.hekai.backend.repository;

import com.hekai.backend.entity.CoursePackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursePackageRepository extends JpaRepository<CoursePackage, Integer> {
    List<CoursePackage> findCoursePackagesByPackageId(Integer packageId);
    List<CoursePackage> findCoursePackagesByCourseId(Integer courseId);
}