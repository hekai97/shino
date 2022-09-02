package com.hekai.backend.controller.client;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.entity.CurCourse;
import com.hekai.backend.entity.CurCourseType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 客户当然控制器
 *
 * @author 17316
 * @date 2022/09/02
 */
@RestController
@RequestMapping(value = "/course")
public class ClientCourseController {

    /**
     * 用户购买课程列表
     *
     * @param httpSession http会话
     * @return {@link ServerResponse}<{@link List}<{@link CurCourse}>>
     */
    @RequestMapping(value = "/getUserPurchasedCourseList",method = RequestMethod.GET)
    public ServerResponse<List<CurCourse>> getUserPurchasedCourseList(HttpSession httpSession){
        return null;
    }

    /**
     * 获取所有课程类别
     *
     * @return {@link ServerResponse}<{@link List}<{@link CurCourseType}>>
     */
    @RequestMapping(value = "/getAllCourseCategory",method = RequestMethod.GET)
    public ServerResponse<List<CurCourseType>> getAllCourseCategory(){
        return null;
    }

    /**
     * 按类别获取课程列表
     *
     * @param id id
     * @return {@link ServerResponse}<{@link List}<{@link CurCourse}>>
     */
    @RequestMapping(value = "/getCourseListByCategoryId",method = RequestMethod.GET)
    public ServerResponse<List<CurCourse>> getCourseListByCategory(Integer id){
        return null;
    }

    /**
     * 按id获取课程详细内容
     *
     * @param id id
     * @return {@link ServerResponse}<{@link CurCourse}>
     */
    @RequestMapping(value = "/getCourseDetailById",method = RequestMethod.GET)
    public ServerResponse<CurCourse> getCourseDetail(Integer id){
        return null;
    }
}
