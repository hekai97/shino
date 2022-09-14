package com.hekai.backend.service;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.CourseDto;
import com.hekai.backend.entity.Course;
import com.hekai.backend.entity.CourseCategory;
import com.hekai.backend.entity.EmployeeUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 课程服务
 *
 * @author 17316
 * @date 2022/09/06
 */
public interface CourseService {
    /**
     * 把所有课程可分页
     *
     * @param pageable 可分页
     * @return {@link ServerResponse}<{@link Page}<{@link CourseDto}>>
     */
    ServerResponse<Page<CourseDto>> getAllCoursePageable(Pageable pageable);

    /**
     * 课程可分页按类别id
     *
     * @param pageable   可分页
     * @param categoryId 类别id
     * @return {@link ServerResponse}<{@link Page}<{@link CourseDto}>>
     */
    ServerResponse<Page<CourseDto>> getCoursesPageableByCategoryId(Pageable pageable,Integer categoryId);

    /**
     * 获得课程列表
     *
     * @return {@link ServerResponse}<{@link List}<{@link CourseDto}>>
     */
    ServerResponse<List<CourseDto>> getCourseList();

    /**
     * 创建课程
     *
     * @param operator 操作符
     * @param course   课程
     * @return {@link ServerResponse}<{@link Course}>
     */
    ServerResponse<Course> createCourse(EmployeeUser operator, Course course);

    /**
     * 更新课程信息
     *
     * @param operator 操作符
     * @param course   课程
     * @return {@link ServerResponse}<{@link Course}>
     */
    ServerResponse<Course> updateCourseInfo(EmployeeUser operator,Course course);

    /**
     * 删除课程数量
     *
     * @param curUser      坏蛋用户
     * @param courseNumber 课程数量
     * @return {@link ServerResponse}<{@link String}>
     */
    ServerResponse<String> deleteCourseByNumber(EmployeeUser curUser, String courseNumber);

    /**
     * 得到课程细节
     *
     * @param id id
     * @return {@link ServerResponse}<{@link Course}>
     */
    ServerResponse<Course> getCourseDetail(Integer id);

    /**
     * 用户购买课程列表
     *
     * @param id id
     * @return {@link ServerResponse}<{@link List}<{@link Course}>>
     */
    ServerResponse<List<Course>> getUserPurchasedCourseList(int id);

    /**
     * 把所有课程类别
     *
     * @return {@link ServerResponse}<{@link List}<{@link CourseCategory}>>
     */
    ServerResponse<List<CourseCategory>> getAllCourseCategory();

    ServerResponse<List<CourseDto>> getRandomCourse(int number);
}
