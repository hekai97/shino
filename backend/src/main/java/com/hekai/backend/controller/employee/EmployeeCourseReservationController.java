package com.hekai.backend.controller.employee;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.CourseReservationDto;
import com.hekai.backend.entity.EmployeeUser;
import com.hekai.backend.service.CourseReservationService;
import com.hekai.backend.utils.ConstUtil;
import io.swagger.v3.oas.annotations.Parameter;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 员工课程预订控制器
 *
 * @author 17316
 * @date 2022/09/06
 */
@RestController
@RequestMapping(value = "/employee/reservation")
public class EmployeeCourseReservationController {
    @Autowired
    private CourseReservationService courseReservationService;

    /**
     * 得到课程预订可分页列表
     *
     * @param httpSession http会话
     * @param pageable    可分页
     * @return {@link ServerResponse}<{@link Page}<{@link CourseReservationDto}>>
     */
    @RequestMapping(value = "/getCourseReservationListPageable",method = RequestMethod.POST)
    public ServerResponse<Page<CourseReservationDto>> getCourseReservationListPageable(HttpSession httpSession, @ParameterObject Pageable pageable){
        EmployeeUser curUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.EMPLOYEE_USER);
        if(curUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return courseReservationService.getCourseReservationListPageable(curUser,pageable);
    }

    /**
     * 删除预订
     *
     * @param httpSession   http会话
     * @param reservationId 预订id
     * @return {@link ServerResponse}<{@link String}>
     */
    @RequestMapping(value = "/deleteReservation",method = RequestMethod.POST)
    public ServerResponse<String> deleteReservation(HttpSession httpSession,@Parameter Integer reservationId){
        EmployeeUser curUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.EMPLOYEE_USER);
        if(curUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return courseReservationService.deleteReservation(reservationId);
    }
}
