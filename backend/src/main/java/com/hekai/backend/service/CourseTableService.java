package com.hekai.backend.service;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.CourseTableDto;
import com.hekai.backend.dto.NewCourseTableDto;
import com.hekai.backend.dto.TeacherDto;
import com.hekai.backend.entity.CourseTable;
import com.hekai.backend.entity.EmployeeUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 课程表服务
 *
 * @author 17316
 * @date 2022/09/06
 */
public interface CourseTableService {
    /**
     * 得到所有调度可分页
     *
     * @param curUser  坏蛋用户
     * @param pageable 可分页
     * @return {@link ServerResponse}<{@link Page}<{@link CourseTableDto}>>
     */
    ServerResponse<Page<CourseTableDto>> getAllSchedulingPageable(EmployeeUser curUser, Pageable pageable);

    /**
     * 通过id获取调度细节
     *
     * @param curUser 当前用户
     * @param id      id
     * @return {@link ServerResponse}<{@link CourseTableDto}>
     */
    ServerResponse<CourseTableDto> getSchedulingDetailById(EmployeeUser curUser, Integer id);

    /**
     * 创建调度
     *
     * @param courseTable 当然表
     * @return {@link ServerResponse}<{@link CourseTableDto}>
     */
    ServerResponse<CourseTableDto> createScheduling(NewCourseTableDto newCourseTableDto);

    /**
     * 删除表id
     *
     * @param courseTableId 当然表id
     * @return {@link ServerResponse}<{@link String}>
     */
    ServerResponse<String> deleteCourseTableById(Integer courseTableId);

    /**
     * 更新过程表
     *
     * @param courseTable 当然表
     * @return {@link ServerResponse}<{@link CourseTableDto}>
     */
    ServerResponse<CourseTableDto> updateCourseTable(CourseTable courseTable);

    ServerResponse<List<TeacherDto>> getFreeTeacherByTime(Integer storeId,String date, Integer timeId,Integer courseId);

    ServerResponse<List<CourseTableDto>> getAllCourseTableList(Integer storeId);
}
