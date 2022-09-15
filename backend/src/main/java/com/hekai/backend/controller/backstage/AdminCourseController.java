package com.hekai.backend.controller.backstage;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.CourseDto;
import com.hekai.backend.dto.CourseRankingDto;
import com.hekai.backend.entity.Course;
import com.hekai.backend.entity.CourseCategory;
import com.hekai.backend.entity.EmployeeUser;
import com.hekai.backend.service.CourseReservationService;
import com.hekai.backend.service.CourseService;
import com.hekai.backend.utils.CommonFunction;
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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
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
    @Autowired
    private CourseReservationService courseReservationService;

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

    @RequestMapping(value = "/getCoursesPageableByStoreId",method = RequestMethod.GET)
public ServerResponse<Page<CourseDto>> getCoursesPageableByStoreId(HttpSession httpSession,@ParameterObject Pageable pageable,@Parameter Integer storeId){
        EmployeeUser curUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(curUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return courseService.getCoursesPageableByStoreId(pageable,storeId);
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

    /**
     * 课程上传图片
     *
     * @param image 图像
     * @return {@link ServerResponse}<{@link String}>
     */
    @RequestMapping(value = "/uploadCourseImage",method = RequestMethod.POST)
    public ServerResponse<String> uploadCourseImage(@RequestBody MultipartFile image){
        return CommonFunction.uploadImage(image,ConstUtil.COURSE_IMAGE_PATH);
    }

    /**
     * 得到课程排名
     *
     * @param httpSession http会话
     * @return {@link ServerResponse}<{@link List}<{@link CourseRankingDto}>>
     */
    @Operation(summary = "后端要求的接口，该接口可以获取开课的排名，按照开课的次数")
    @RequestMapping(value = "/getCourseRanking",method = RequestMethod.GET)
    public ServerResponse<List<CourseRankingDto>> getCourseRanking(HttpSession httpSession){
        EmployeeUser curUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(curUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return courseReservationService.getCourseRanking();
    }

    /**
     * 课程类别收入类别id
     *
     * @param httpSession http会话
     * @param categoryId  类别id
     * @return {@link ServerResponse}<{@link BigDecimal}>
     */
    @Operation(summary = "管理端要的接口，该接口能根据课程分类的Id获取其分类下的收益额")
    @RequestMapping(value = "/getCourseCategoryIncomeByCategoryId",method = RequestMethod.POST)
    public ServerResponse<BigDecimal> getCourseCategoryIncomeByCategoryId(HttpSession httpSession,@Parameter Integer categoryId){
        EmployeeUser curUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(curUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return courseReservationService.getCourseCategoryIncomeByCategoryId(categoryId);
    }

    /**
     * 得到课程类别列表
     *
     * @param httpSession http会话
     * @return {@link ServerResponse}<{@link List}<{@link CourseCategory}>>
     */
    @Operation(summary = "获取课程分类")
    @RequestMapping(value = "/getCourseCategoryList",method = RequestMethod.GET)
    public ServerResponse<List<CourseCategory>> getCourseCategoryList(HttpSession httpSession){
        EmployeeUser curUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(curUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return courseService.getAllCourseCategory();
    }  
}
