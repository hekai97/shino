package com.hekai.backend.service;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.CourseTableDto;
import com.hekai.backend.entity.CourseTable;
import com.hekai.backend.entity.EmployeeUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 当然餐桌服务
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
     * @param curUser 坏蛋用户
     * @param id      id
     * @return {@link ServerResponse}<{@link CourseTableDto}>
     */
    ServerResponse<CourseTableDto> getSchedulingDetailById(EmployeeUser curUser, Integer id);

    ServerResponse<CourseTableDto> createScheduling(CourseTable courseTable);

    ServerResponse<String> deleteCourseTableById(Integer courseTableId);

    ServerResponse<CourseTableDto> updateCourseTable(CourseTable courseTable);
}
