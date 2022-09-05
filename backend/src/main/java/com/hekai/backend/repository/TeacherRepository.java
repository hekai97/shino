package com.hekai.backend.repository;

import com.hekai.backend.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Teacher findTeacherByNumber(String Number);
    Teacher findTeacherById(Integer id);

    List<Teacher> findTeachersByStoreId(Integer storeId);
}