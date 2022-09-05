package com.hekai.backend.controller.client;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.CourseDto;
import com.hekai.backend.dto.TeacherDto;
import com.hekai.backend.entity.*;
import com.hekai.backend.service.CourseService;
import com.hekai.backend.service.TeacherService;

import com.hekai.backend.utils.ConstUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    @Autowired
    private CourseService courseService;
    @Autowired
    private TeacherService teacherService;

    /**
     * 用户购买课程列表
     *
     * @param httpSession http会话
     * @return {@link ServerResponse}<{@link List}<{@link Course}>>
     */
    @RequestMapping(value = "/getUserPurchasedCourseList",method = RequestMethod.GET)
    public ServerResponse<List<Course>> getUserPurchasedCourseList(HttpSession httpSession){
        User user = (User) httpSession.getAttribute(ConstUtil.NORMAL_USER);
        if (user == null){
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        return courseService.getUserPurchasedCourseList(user.getId());
    }

    /**
     * 获取所有课程类别
     *
     * @return {@link ServerResponse}<{@link List}<{@link CourseCategory}>>
     */
    @RequestMapping(value = "/getAllCourseCategory",method = RequestMethod.GET)
    public ServerResponse<List<CourseCategory>> getAllCourseCategory(){
        return courseService.getAllCourseCategory();
    }

    /**
     * 按类别获取课程列表
     *
     * @param id id
     * @return {@link ServerResponse}<{@link List}<{@link Course}>>
     */
    @RequestMapping(value = "/getCoursesPageableByCategoryId",method = RequestMethod.GET)
    public ServerResponse<Page<CourseDto>> getCoursesPageableByCategoryId(Pageable pageable, Integer id){
        return courseService.getCoursesPageableByCategoryId(pageable,id);
    }

    /**
     * 按id获取课程详细内容
     *
     * @param id id
     * @return {@link ServerResponse}<{@link Course}>
     */
    @RequestMapping(value = "/getCourseDetailById",method = RequestMethod.GET)
    public ServerResponse<Course> getCourseDetail(Integer id){
        return courseService.getCourseDetail(id);
    }

    @RequestMapping(value = "/getStoreList",method = RequestMethod.GET)
    public ServerResponse<List<Store>> getStoreList(){
        return courseService.getStoreList();
    }

    @RequestMapping(value = "/getStoreByStoreNumber",method = RequestMethod.GET)
    public ServerResponse<Store> getStoreByStoreNumber(String storeNumber){
        return courseService.getStoreByStoreNumber(storeNumber);
    }

    @RequestMapping(value = "/getTeacherListPageable",method = RequestMethod.POST)
    public ServerResponse<Page<TeacherDto>> getTeacherList(Pageable pageable){
        return teacherService.getTeacherListPageable(pageable);
    }

    @RequestMapping(value = "/getTeachersByStoreId",method = RequestMethod.POST)
    public ServerResponse<List<Teacher>> getTeachersByStoreId(Integer storeId){
        return teacherService.getTeachersByStoreId(storeId);
    }

    @RequestMapping(value = "/getTeacherByNumber",method = RequestMethod.POST)
    public ServerResponse<TeacherDto> getTeacherByNumber(String number){
        return teacherService.getTeacherByNumber(number);
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
