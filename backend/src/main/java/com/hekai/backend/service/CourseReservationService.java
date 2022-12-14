package com.hekai.backend.service;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.CourseRankingDto;
import com.hekai.backend.dto.CourseReservationDto;
import com.hekai.backend.entity.CourseReservation;
import com.hekai.backend.entity.EmployeeUser;
import com.hekai.backend.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

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

    /**
     * 得到保留
     *
     * @param userId 用户id
     * @return {@link ServerResponse}<{@link List}<{@link CourseReservationDto}>>
     */
    ServerResponse<List<CourseReservationDto>> getReservations(Integer userId);

    /**
     * 创建预订
     *
     * @param user              用户
     * @param courseReservation 课程预订
     * @return {@link ServerResponse}<{@link CourseReservationDto}>
     */
    ServerResponse<CourseReservationDto> createReservation(User user, CourseReservation courseReservation);

    /**
     * 取消预订
     *
     * @param courseReservationId 课程预订id
     * @return {@link ServerResponse}<{@link String}>
     */
    ServerResponse<String> cancelReservation(Integer courseReservationId);

    /**
     * 得到课程排名
     *
     * @return {@link ServerResponse}<{@link List}<{@link CourseRankingDto}>>
     */
    ServerResponse<List<CourseRankingDto>> getCourseRanking();

    /**
     * 课程类别收入类别id
     *
     * @param categoryId 类别id
     * @return {@link ServerResponse}<{@link BigDecimal}>
     */
    ServerResponse<BigDecimal> getCourseCategoryIncomeByCategoryId(Integer categoryId);

    ServerResponse<Page<CourseReservationDto>> getCourseReservationNoStartPageable(EmployeeUser curUser, Pageable pageable);

    ServerResponse<User> getCourseReservationByOrderNumber(Integer orderId);
}
