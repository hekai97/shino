package com.hekai.backend.repository;

import com.hekai.backend.entity.CourseTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseTableRepository extends JpaRepository<CourseTable, Integer> {
    Page<CourseTable> findAllByStoreId(Integer storeId, Pageable pageable);

    CourseTable findCourseTableById(Integer id);
}