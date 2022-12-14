package com.hekai.backend.controller.employee;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.CourseTableDto;
import com.hekai.backend.dto.NewCourseTableDto;
import com.hekai.backend.dto.TeacherDto;
import com.hekai.backend.entity.CourseTable;
import com.hekai.backend.entity.CourseTimeConfig;
import com.hekai.backend.entity.EmployeeUser;
import com.hekai.backend.service.CourseTableService;
import com.hekai.backend.service.CourseTimeConfigService;
import com.hekai.backend.utils.ConstUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 员工调度控制器
 *
 * @author 17316
 * @date 2022/09/03
 */
@RestController
@RequestMapping(value = "/employee/Scheduling")
public class EmployeeSchedulingController {
    @Autowired
    private CourseTimeConfigService courseTimeConfigService;
    @Autowired
    private CourseTableService courseTableService;

    /**
     * 得到所有调度可分页
     *
     * @param httpSession http会话
     * @param pageable    可分页
     * @return {@link ServerResponse}<{@link Page}<{@link CourseTableDto}>>
     */
    @RequestMapping(value = "/getAllSchedulingPageable", method = RequestMethod.GET)
    public ServerResponse<Page<CourseTableDto>> getAllSchedulingPageable(HttpSession httpSession,@ParameterObject Pageable pageable) {
        EmployeeUser curUser = (EmployeeUser) httpSession.getAttribute(ConstUtil.EMPLOYEE_USER);
        if (curUser == null) {
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return courseTableService.getAllSchedulingPageable(curUser, pageable);
    }

    /**
     * 通过id获取调度细节
     *
     * @param httpSession http会话
     * @param id          id
     * @return {@link ServerResponse}<{@link CourseTableDto}>
     */
    @RequestMapping(value = "/getSchedulingDetailById", method = RequestMethod.GET)
    public ServerResponse<CourseTableDto> getSchedulingDetailById(HttpSession httpSession,@Parameter Integer id) {
        EmployeeUser curUser = (EmployeeUser) httpSession.getAttribute(ConstUtil.EMPLOYEE_USER);
        if (curUser == null) {
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return courseTableService.getSchedulingDetailById(curUser, id);
    }

    /**
     * 得到课程时间配置
     *
     * @param httpSession http会话
     * @return {@link ServerResponse}<{@link CourseTimeConfig}>
     */
    @RequestMapping(value = "/getCourseTimeConfig", method = RequestMethod.GET)
    public ServerResponse<CourseTimeConfig> getCourseTimeConfig(HttpSession httpSession) {
        return courseTimeConfigService.getCourseTimeConfig();
    }

    /**
     * 创建调度
     *
     * @param httpSession http会话
     * @return {@link ServerResponse}<{@link CourseTableDto}>
     */
    @RequestMapping(value = "/createScheduling", method = RequestMethod.POST)
    public ServerResponse<CourseTableDto> createScheduling(HttpSession httpSession,
                                                           @RequestBody NewCourseTableDto newCourseTableDto) {
        EmployeeUser curUser = (EmployeeUser) httpSession.getAttribute(ConstUtil.EMPLOYEE_USER);
        if (curUser == null) {
            return ServerResponse.createByErrorMessage("未登录！");
        }
        newCourseTableDto.setStoreId(curUser.getStoreId());
        return courseTableService.createScheduling(newCourseTableDto);
    }

    /**
     * 删除表id
     *
     * @param httpSession   http会话
     * @param courseTableId 当然表id
     * @return {@link ServerResponse}<{@link String}>
     */
    @RequestMapping(value = "/deleteCourseTableById", method = RequestMethod.GET)
    public ServerResponse<String> deleteCourseTableById(HttpSession httpSession,@Parameter Integer courseTableId) {
        EmployeeUser curUser = (EmployeeUser) httpSession.getAttribute(ConstUtil.EMPLOYEE_USER);
        if (curUser == null) {
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return courseTableService.deleteCourseTableById(courseTableId);
    }

    /**
     * 更新过程表
     *
     * @param httpSession http会话
     * @param courseTable 当然表
     * @return {@link ServerResponse}<{@link CourseTableDto}>
     */
    @RequestMapping(value = "/updateCourseTable", method = RequestMethod.POST)
    public ServerResponse<CourseTableDto> updateCourseTable(HttpSession httpSession,@RequestBody CourseTable courseTable) {
        EmployeeUser curUser = (EmployeeUser) httpSession.getAttribute(ConstUtil.EMPLOYEE_USER);
        if (curUser == null) {
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return courseTableService.updateCourseTable(courseTable);
    }

    @Operation(summary = "根据时间段以及用户要求的课程Id来获取空闲的老师")
    @RequestMapping(value = "/getFreeTeacherByTime", method = RequestMethod.GET)
    public ServerResponse<List<TeacherDto>> getFreeTeacherByTime(HttpSession httpSession,
                                                                 @Parameter(description = "具体是哪一天，格式是2000-01-01") String date,
                                                                 @Parameter(description = "每天四节课，假如是9:00-11:00，这个参数就填1，以此类推") Integer timeId,
                                                                 @Parameter(description = "用户预约的课程Id") Integer courseId) {
        EmployeeUser curUser = (EmployeeUser) httpSession.getAttribute(ConstUtil.EMPLOYEE_USER);
        if (curUser == null) {
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return courseTableService.getFreeTeacherByTime(curUser.getStoreId(),date, timeId,courseId);
    }

    @RequestMapping(value = "/getAllCourseTableList",method = RequestMethod.GET)
    public ServerResponse<List<CourseTableDto>> getAllCourseTableList(HttpSession httpSession){
        EmployeeUser curUser = (EmployeeUser) httpSession.getAttribute(ConstUtil.EMPLOYEE_USER);
        if (curUser == null) {
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return courseTableService.getAllCourseTableList(curUser.getStoreId());
    }
}