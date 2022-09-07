package com.hekai.backend.controller.backstage;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.CourseDto;
import com.hekai.backend.entity.Course;
import com.hekai.backend.entity.EmployeeUser;
import com.hekai.backend.service.CourseService;
import com.hekai.backend.utils.ConstUtil;
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
 * 课程管理控制器
 *
 * @author 17316
 * @date 2022/09/02
 */
@RestController
@RequestMapping(value = "/admin/course")
public class AdminCourseController {
    @Autowired
    private CourseService courseService;

    /**
     * 把所有课程可分页
     *
     * @param httpSession http会话
     * @param pageable    可分页
     * @return {@link ServerResponse}<{@link Page}<{@link CourseDto}>>
     */
    @RequestMapping(value = "/getAllCoursePageable",method = RequestMethod.GET)
    public ServerResponse<Page<CourseDto>> getAllCoursePageable(HttpSession httpSession, @ParameterObject Pageable pageable){
        EmployeeUser curUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(curUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return courseService.getAllCoursePageable(pageable);
    }

    /**
     * 课程可分页按类别id
     *
     * @param httpSession http会话
     * @param pageable    可分页
     * @param categoryId  类别id
     * @return {@link ServerResponse}<{@link Page}<{@link CourseDto}>>
     */
    @RequestMapping(value = "/getCoursesPageableByCategoryId",method = RequestMethod.GET)
    public ServerResponse<Page<CourseDto>> getCoursesPageableByCategoryId(HttpSession httpSession,@ParameterObject Pageable pageable,@Parameter Integer categoryId){
        EmployeeUser curUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(curUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return courseService.getCoursesPageableByCategoryId(pageable,categoryId);
    }

    /**
     * 获得课程列表
     *
     * @param httpSession http会话
     * @return {@link ServerResponse}<{@link List}<{@link CourseDto}>>
     */
    @RequestMapping(value = "/getCourseList",method = RequestMethod.GET)
    public ServerResponse<List<CourseDto>> getCourseList(HttpSession httpSession){
        EmployeeUser curUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(curUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return courseService.getCourseList();
    }

    /**
     * 创建课程
     *
     * @param httpSession http会话
     * @param course      课程
     * @return {@link ServerResponse}<{@link Course}>
     */
    @RequestMapping(value = "/createCourse",method = RequestMethod.POST)
    public ServerResponse<Course> createCourse(HttpSession httpSession,@RequestBody Course course){
        EmployeeUser curUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(curUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return courseService.createCourse(curUser,course);
    }

    /**
     * 更新课程信息
     *
     * @param httpSession http会话
     * @param course      课程
     * @return {@link ServerResponse}<{@link Course}>
     */
    @RequestMapping(value = "/updateCourseInfo",method = RequestMethod.POST)
    public ServerResponse<Course> updateCourseInfo(HttpSession httpSession,@RequestBody Course course){
        EmployeeUser curUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(curUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return courseService.updateCourseInfo(curUser,course);
    }

    /**
     * 删除课程数量
     *
     * @param httpSession  http会话
     * @param courseNumber 课程数量
     * @return {@link ServerResponse}<{@link String}>
     */
    @RequestMapping(value = "/deleteCourseByNumber",method = RequestMethod.POST)
    public ServerResponse<String> deleteCourseByNumber(HttpSession httpSession,@Parameter String courseNumber){
        EmployeeUser curUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(curUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return courseService.deleteCourseByNumber(curUser,courseNumber);
    }


}
