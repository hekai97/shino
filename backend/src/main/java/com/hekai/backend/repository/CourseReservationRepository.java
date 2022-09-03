package com.hekai.backend.repository;

import com.hekai.backend.entity.CourseReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseReservationRepository extends JpaRepository<CourseReservation, Integer> {
}