package com.hekai.backend.controller.backstage;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.entity.Course;
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
    /**
     * 通过分页查询所有课程页面
     *
     * @param httpSession http会话
     * @param pageSize    页面大小
     * @param pageNumber  页码
     * @return {@link ServerResponse}<{@link List}<{@link Course}>>
     */
    @RequestMapping(value = "/getAllCourseByPage",method = RequestMethod.GET)
    public ServerResponse<List<Course>> getAllCourseByPage(HttpSession httpSession, int pageSize, int pageNumber){
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
