package com.hekai.backend.service;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.CourseDto;
import com.hekai.backend.entity.Course;
import com.hekai.backend.entity.CourseCategory;
import com.hekai.backend.entity.EmployeeUser;
import com.hekai.backend.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseService {
    ServerResponse<Page<CourseDto>> getAllCoursePageable(Pageable pageable);

    ServerResponse<Page<CourseDto>> getCoursesPageableByCategoryId(Pageable pageable,Integer categoryId);

    ServerResponse<List<CourseDto>> getCourseList();

    ServerResponse<Course> createCourse(EmployeeUser operator, Course course);

    ServerResponse<Course> updateCourseInfo(EmployeeUser operator,Course course);

    ServerResponse<String> deleteCourseByNumber(EmployeeUser curUser, String courseNumber);

    ServerResponse<Course> getCourseDetail(Integer id);

    ServerResponse<List<Course>> getUserPurchasedCourseList(int id);

    ServerResponse<List<CourseCategory>> getAllCourseCategory();

    ServerResponse<List<Store>> getStoreList();

    ServerResponse<Store> getStoreByStoreNumber(String storeNumber);
}
