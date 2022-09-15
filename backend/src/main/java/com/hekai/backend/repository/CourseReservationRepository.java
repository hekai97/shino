package com.hekai.backend.repository;

import com.hekai.backend.entity.CourseReservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseReservationRepository extends JpaRepository<CourseReservation, Integer> {
    Page<CourseReservation> findAllByStoreId(Integer storeId, Pageable pageable);
    CourseReservation findCourseReservationById(Integer id);
    //查看每门课开课的次数,不要动这个代码
    @Query(value = "select distinct course_id as course_id, COUNT(*) as count from course_reservation group by course_id", nativeQuery = true)
    List<Object[]> findCourseRankingCount();
}