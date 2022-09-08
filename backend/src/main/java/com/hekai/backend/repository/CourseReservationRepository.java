package com.hekai.backend.repository;

import com.hekai.backend.entity.CourseReservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseReservationRepository extends JpaRepository<CourseReservation, Integer> {
    Page<CourseReservation> findAllByStoreId(Integer storeId, Pageable pageable);
    CourseReservation findCourseReservationById(Integer id);
}