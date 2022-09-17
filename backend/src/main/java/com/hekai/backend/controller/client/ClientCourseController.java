package com.hekai.backend.controller.client;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.CourseDto;
import com.hekai.backend.dto.CourseReservationDto;
import com.hekai.backend.dto.StoreDto;
import com.hekai.backend.dto.TeacherDto;
import com.hekai.backend.entity.*;
import com.hekai.backend.service.CourseReservationService;
import com.hekai.backend.service.CourseService;
import com.hekai.backend.service.StoreService;
import com.hekai.backend.service.TeacherService;

import com.hekai.backend.utils.ConstUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 客户当然控制器
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
    @Autowired
    private StoreService storeService;
    @Autowired
    private CourseReservationService courseReservationService;

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
     * 把所有课程类别
     * 获取所有课程类别
     *
     * @return {@link ServerResponse}<{@link List}<{@link CourseCategory}>>
     */
    @RequestMapping(value = "/getAllCourseCategory",method = RequestMethod.GET)
    public ServerResponse<List<CourseCategory>> getAllCourseCategory(){
        return courseService.getAllCourseCategory();
    }

    /**
     * 课程可分页按类别id
     * 按类别获取课程列表
     *
     * @param id       id
     * @param pageable 可分页
     * @return {@link ServerResponse}<{@link Page}<{@link CourseDto}>>
     */
    @RequestMapping(value = "/getCoursesPageableByCategoryId",method = RequestMethod.GET)
    public ServerResponse<Page<CourseDto>> getCoursesPageableByCategoryId(@ParameterObject Pageable pageable, @Parameter Integer id){
        return courseService.getCoursesPageableByCategoryId(pageable,id);
    }

    /**
     * 得到课程细节
     * 按id获取课程详细内容
     *
     * @param id id
     * @return {@link ServerResponse}<{@link Course}>
     */
    @RequestMapping(value = "/getCourseDetailById",method = RequestMethod.GET)
    public ServerResponse<Course> getCourseDetail(@Parameter Integer id){
        return courseService.getCourseDetail(id);
    }

    /**
     * 获取存储列表
     *
     * @return {@link ServerResponse}<{@link List}<{@link StoreDto}>>
     */
    @RequestMapping(value = "/getStoreList",method = RequestMethod.GET)
    public ServerResponse<List<StoreDto>> getStoreList(){
        return storeService.getStoreList();
    }

    /**
     * 得到存储,存储数字
     *
     * @param storeNumber 商店数量
     * @return {@link ServerResponse}<{@link StoreDto}>
     */
    @RequestMapping(value = "/getStoreByStoreNumber",method = RequestMethod.GET)
    public ServerResponse<StoreDto> getStoreByStoreNumber(@Parameter String storeNumber){
        return storeService.getStoreByStoreNumber(storeNumber);
    }

    /**
     * 得到老师名单
     *
     * @param pageable 可分页
     * @return {@link ServerResponse}<{@link Page}<{@link TeacherDto}>>
     */
    @RequestMapping(value = "/getTeacherListPageable",method = RequestMethod.POST)
    public ServerResponse<Page<TeacherDto>> getTeacherList(@ParameterObject Pageable pageable){
        return teacherService.getTeacherListPageable(pageable);
    }

    /**
     * 教师通过存储id
     *
     * @param storeId 存储id
     * @return {@link ServerResponse}<{@link List}<{@link Teacher}>>
     */
    @RequestMapping(value = "/getTeachersByStoreId",method = RequestMethod.POST)
    public ServerResponse<List<Teacher>> getTeachersByStoreId(@Parameter Integer storeId){
        return teacherService.getTeachersByStoreId(storeId);
    }

    /**
     * 得到老师数量
     * 通过教师编号获取教师详情
     *
     * @param number 数量
     * @return {@link ServerResponse}<{@link TeacherDto}>
     */
    @RequestMapping(value = "/getTeacherByNumber",method = RequestMethod.POST)
    public ServerResponse<TeacherDto> getTeacherByNumber(@Parameter String number){
        return teacherService.getTeacherByNumber(number);
    }

    /**
     * 得到保留
     *
     * @param httpSession http会话
     * @return {@link ServerResponse}<{@link List}<{@link CourseReservationDto}>>
     */
    @RequestMapping(value="/getReservations",method = RequestMethod.GET)
    public ServerResponse<List<CourseReservationDto>> getReservations(HttpSession httpSession){
        User user = (User) httpSession.getAttribute(ConstUtil.NORMAL_USER);
        if (user == null){
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        return courseReservationService.getReservations(user.getId());
    }

    /**
     * 创建预订
     *
     * @param courseReservation 课程预订
     * @param httpSession       http会话
     * @return {@link ServerResponse}<{@link CourseReservationDto}>
     */
    @RequestMapping(value = "/createReservation",method = RequestMethod.POST)
    public ServerResponse<CourseReservationDto> createReservation(HttpSession httpSession,@RequestBody CourseReservation courseReservation){
        User user = (User) httpSession.getAttribute(ConstUtil.NORMAL_USER);
        if (user == null){
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        return courseReservationService.createReservation(user,courseReservation);
    }

    /**
     * 取消预订
     *
     * @param courseReservationId 课程预订Id
     * @param httpSession         http会话
     * @return {@link ServerResponse}<{@link String}>
     */
    @RequestMapping(value = "/cancelReservation",method = RequestMethod.POST)
    public ServerResponse<String> cancelReservation(HttpSession httpSession,@Parameter Integer courseReservationId){
        User user = (User) httpSession.getAttribute(ConstUtil.NORMAL_USER);
        if (user == null){
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        return courseReservationService.cancelReservation(courseReservationId);
    }

    @RequestMapping(value = "/getRandomCourse",method = RequestMethod.GET)
    public ServerResponse<List<CourseDto>> getRandomCourse(@Parameter(description = "默认为4") @Nullable Integer number){
        if(number==null){
            number=4;
        }
        return courseService.getRandomCourse(number);
    }
    @RequestMapping(value = "/getStoresPageable",method = RequestMethod.GET)
    public ServerResponse<Page<StoreDto>> getStoresPageable(@ParameterObject Pageable pageable){
        return storeService.getStoresPageable(pageable);
    }
    @RequestMapping(value = "/getCoursesPageableByStoreId",method = RequestMethod.GET)
    public ServerResponse<Page<CourseDto>> getCoursesPageableByStoreId(@ParameterObject Pageable pageable,@Parameter Integer storeId){
        return courseService.getCoursesPageableByStoreId(pageable,storeId);
    }
}
