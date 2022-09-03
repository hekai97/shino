package com.hekai.backend.controller.client;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.entity.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 客户端课程控制器
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
     * @return {@link ServerResponse}<{@link List}<{@link Course}>>
     */
    @RequestMapping(value = "/getUserPurchasedCourseList",method = RequestMethod.GET)
    public ServerResponse<List<Course>> getUserPurchasedCourseList(HttpSession httpSession){
        return null;
    }

    /**
     * 获取所有课程类别
     *
     * @return {@link ServerResponse}<{@link List}<{@link CourseCategory}>>
     */
    @RequestMapping(value = "/getAllCourseCategory",method = RequestMethod.GET)
    public ServerResponse<List<CourseCategory>> getAllCourseCategory(){
        return null;
    }

    /**
     * 按类别获取课程列表
     *
     * @param id id
     * @return {@link ServerResponse}<{@link List}<{@link Course}>>
     */
    @RequestMapping(value = "/getCourseListByCategoryId",method = RequestMethod.GET)
    public ServerResponse<List<Course>> getCourseListByCategory(Integer id){
        return null;
    }

    /**
     * 按id获取课程详细内容
     *
     * @param id id
     * @return {@link ServerResponse}<{@link Course}>
     */
    @RequestMapping(value = "/getCourseDetailById",method = RequestMethod.GET)
    public ServerResponse<Course> getCourseDetail(Integer id){
        return null;
    }

    @RequestMapping(value = "/getStoreList",method = RequestMethod.GET)
    public ServerResponse<List<Store>> getStoreList(){
        return null;
    }

    @RequestMapping(value = "/getStoreByStoreNumber",method = RequestMethod.GET)
    public ServerResponse<Store> getStoreByStoreNumber(String storeNumber){
        return null;
    }

    @RequestMapping(value = "/getTeacherList",method = RequestMethod.POST)
    public ServerResponse<List<Teacher>> getTeacherList(){
        return null;
    }

    @RequestMapping(value = "/getTeachersByStoreId",method = RequestMethod.POST)
    public ServerResponse<List<Teacher>> getTeachersByStoreId(Integer storeId){
        return null;
    }

    @RequestMapping(value = "/getTeacherByNumber",method = RequestMethod.POST)
    public ServerResponse<Teacher> getTeacherByNumber(String number){
        return null;
    }

    @RequestMapping(value = "/createReservation",method = RequestMethod.POST)
    public ServerResponse<CourseReservation> createReservation(CourseReservation courseReservation){
        return null;
    }
    @RequestMapping(value = "/cancelReservation",method = RequestMethod.POST)
    public ServerResponse<String> cancelReservation(CourseReservation courseReservation){
        return null;
    }
}
