package com.hekai.backend.controller.employee;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.entity.CourseTable;
import com.hekai.backend.entity.CourseTimeConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 员工调度控制器
 *
 * @author 17316
 * @date 2022/09/03
 */
@RestController
@RequestMapping(value = "/employee/Scheduling")
public class EmployeeSchedulingController {
    /**
     * 得到所有调度可分页
     *
     * @param httpSession http会话
     * @param pageable    可分页
     * @return {@link ServerResponse}<{@link Page}<{@link CourseTable}>>
     */
    @RequestMapping(value = "/getAllSchedulingPageable",method = RequestMethod.GET)
    public ServerResponse<Page<CourseTable>> getAllSchedulingPageable(HttpSession httpSession, Pageable pageable){
        return null;
    }

    /**
     * 通过id获取调度细节
     *
     * @param httpSession http会话
     * @param id          id
     * @return {@link ServerResponse}<{@link CourseTable}>
     */
    @RequestMapping(value = "/getSchedulingDetailById",method = RequestMethod.GET)
    public ServerResponse<CourseTable> getSchedulingDetailById(HttpSession httpSession,Integer id){
        return null;
    }

    /**
     * 得到课程时间配置
     *
     * @param httpSession http会话
     * @return {@link ServerResponse}<{@link CourseTimeConfig}>
     */
    @RequestMapping(value = "/getCourseTimeConfig",method = RequestMethod.GET)
    public ServerResponse<CourseTimeConfig> getCourseTimeConfig(HttpSession httpSession){
        return null;
    }

}
