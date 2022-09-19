package com.hekai.backend.repository;

import com.hekai.backend.entity.RelationStoreCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelationStoreCourseRepository extends JpaRepository<RelationStoreCourse, Integer> {

    List<RelationStoreCourse> findRelationStoreCoursesByStoreId(Integer storeId);

    RelationStoreCourse findRelationStoreCourseByCourseIdAndStoreId(Integer courseId, Integer storeId);

    List<RelationStoreCourse> findRelationStoreCoursesByCourseId(Integer id);
}