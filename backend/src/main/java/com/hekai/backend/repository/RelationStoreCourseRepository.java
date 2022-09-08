package com.hekai.backend.repository;

import com.hekai.backend.entity.RelationStoreCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationStoreCourseRepository extends JpaRepository<RelationStoreCourse, Integer> {
}