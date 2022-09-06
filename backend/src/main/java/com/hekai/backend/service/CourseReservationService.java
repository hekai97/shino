package com.hekai.backend.service;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.CourseReservationDto;
import com.hekai.backend.entity.EmployeeUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 课程预订服务
 *
 * @author 17316
 * @date 2022/09/06
 */
public interface CourseReservationService {
    /**
     * 得到课程预订可分页列表
     *
     * @param curUser  坏蛋用户
     * @param pageable 可分页
     * @return {@link ServerResponse}<{@link Page}<{@link CourseReservationDto}>>
     */
    ServerResponse<Page<CourseReservationDto>> getCourseReservationListPageable(EmployeeUser curUser, Pageable pageable);

    /**
     * 删除预订
     *
     * @param reservationId 预订id
     * @return {@link ServerResponse}<{@link String}>
     */
    ServerResponse<String> deleteReservation(Integer reservationId);
}
