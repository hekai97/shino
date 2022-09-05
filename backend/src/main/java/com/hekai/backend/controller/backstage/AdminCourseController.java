package com.hekai.backend.controller.backstage;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 课程管理控制器
 *
 * @author 17316
 * @date 2022/09/02
 */
@RestController
@RequestMapping(value = "/admin/course")
public class AdminCourseController {
    /**
     * 把所有课程可分页
     *
     * @param httpSession http会话
     * @param pageable    可分页
     * @return {@link ServerResponse}<{@link Page}<{@link Course}>>
     */
    @RequestMapping(value = "/getAllCoursePageable",method = RequestMethod.GET)
    public ServerResponse<Page<Course>> getAllCoursePageable(HttpSession httpSession, Pageable pageable){
        return null;
    }

    /**
     * 创建课程
     *
     * @param httpSession http会话
     * @param course      课程
     * @return {@link ServerResponse}<{@link String}>
     */
    @RequestMapping(value = "/createCourse",method = RequestMethod.POST)
    public ServerResponse<String> createCourse(HttpSession httpSession,Course course){
        return null;
    }

    @RequestMapping(value = "/updateCourseInfo",method = RequestMethod.POST)
    public ServerResponse<Course> updateCourseInfo(HttpSession httpSession,Course course){
        return null;
    }

    @RequestMapping(value = "/deleteCourse",method = RequestMethod.POST)
    public ServerResponse<Course> deleteCourse(HttpSession httpSession,Integer id){
        return null;
    }


}
