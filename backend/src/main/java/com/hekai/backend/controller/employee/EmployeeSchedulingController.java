package com.hekai.backend.controller.employee;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.entity.CourseTable;
import com.hekai.backend.entity.CourseTimeConfig;
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
    /**
     * 得到所有调度可分页
     *
     * @param httpSession http会话
     * @param pageSize    页面大小
     * @param pageNumber  页码
     * @return {@link ServerResponse}<{@link List}<{@link CourseTable}>>
     */
    @RequestMapping(value = "/getAllSchedulingPageable",method = RequestMethod.GET)
    public ServerResponse<List<CourseTable>> getAllSchedulingPageable(HttpSession httpSession,Integer pageSize,Integer pageNumber){
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
