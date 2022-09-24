package com.hekai.backend.repository;

import com.hekai.backend.entity.CourseTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Repository
public interface CourseTableRepository extends JpaRepository<CourseTable, Integer> {
    Page<CourseTable> findAllByStoreId(Integer storeId, Pageable pageable);
    List<CourseTable> findAllByStoreId(Integer storeId);

    CourseTable findCourseTableById(Integer id);

    List<CourseTable> findCourseTablesByTeacherId(Integer id);

    List<CourseTable> findCourseTablesByStoreIdAndCourseIdAndTeacherIdInAndReservationDateAndBeginTimeAndEndTime(Integer storeId, Integer courseId, List<Integer> teacherId, Date reservationDate, Time beginTime, Time endTime);

    List<CourseTable> findCourseTablesByStoreIdAndTeacherIdInAndReservationDateAndBeginTimeAndEndTime(Integer storeId, List<Integer> teacherId, Date reservationDate, Time beginTime, Time endTime);
}