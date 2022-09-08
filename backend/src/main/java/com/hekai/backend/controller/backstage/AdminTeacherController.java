package com.hekai.backend.controller.backstage;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.TeacherDto;
import com.hekai.backend.entity.EmployeeUser;
import com.hekai.backend.entity.Teacher;
import com.hekai.backend.service.TeacherService;
import com.hekai.backend.utils.CommonFunction;
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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

/**
 * 管理老师控制器
 *
 * @author 17316
 * @date 2022/09/06
 */
@RestController
@RequestMapping(value = "/admin/teacher")
public class AdminTeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * 得到老师可分页列表
     *
     * @param httpSession http会话
     * @param pageable    可分页
     * @return {@link ServerResponse}<{@link Page}<{@link TeacherDto}>>
     */
    @RequestMapping(value = "/getTeacherListPageable", method = RequestMethod.POST)
    public ServerResponse<Page<TeacherDto>> getTeacherListPageable(HttpSession httpSession, @ParameterObject Pageable pageable) {
        EmployeeUser employeeUser = (EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if (employeeUser == null) {
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return teacherService.getTeacherListPageable(pageable);
    }

    /**
     * 得到老师数量
     *
     * @param httpSession http会话
     * @param number      数量
     * @return {@link ServerResponse}<{@link TeacherDto}>
     */
    @RequestMapping(value = "/getTeacherByNumber", method = RequestMethod.POST)
    public ServerResponse<TeacherDto> getTeacherByNumber(HttpSession httpSession, @Parameter String number) {
        EmployeeUser employeeUser = (EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if (employeeUser == null) {
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return teacherService.getTeacherByNumber(number);
    }

    /**
     * 通过id获取老师
     *
     * @param httpSession http会话
     * @param id          id
     * @return {@link ServerResponse}<{@link TeacherDto}>
     */
    @RequestMapping(value = "/getTeacherById", method = RequestMethod.POST)
    public ServerResponse<TeacherDto> getTeacherById(HttpSession httpSession, @Parameter Integer id) {
        EmployeeUser employeeUser = (EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if (employeeUser == null) {
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return teacherService.getTeacherById(id);
    }

    /**
     * 添加老师
     *
     * @param httpSession http会话
     * @param teacher     老师
     * @return {@link ServerResponse}<{@link Teacher}>
     */
    @RequestMapping(value = "/addTeacher", method = RequestMethod.POST)
    public ServerResponse<Teacher> addTeacher(HttpSession httpSession, @RequestBody Teacher teacher) {
        EmployeeUser employeeUser = (EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if (employeeUser == null) {
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return teacherService.save(teacher);
    }

    /**
     * 更新教师
     *
     * @param httpSession http会话
     * @param teacher     老师
     * @return {@link ServerResponse}<{@link Teacher}>
     */
    @RequestMapping(value = "/updateTeacher", method = RequestMethod.POST)
    public ServerResponse<Teacher> updateTeacher(HttpSession httpSession, @RequestBody Teacher teacher) {
        EmployeeUser employeeUser = (EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if (employeeUser == null) {
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return teacherService.updateTeacher(teacher);
    }
    @RequestMapping(value = "/uploadTeacherImage",method = RequestMethod.POST)
    public ServerResponse<String> uploadTeacherImage(@RequestBody MultipartFile image){
        return CommonFunction.uploadImage(image,ConstUtil.TEACHER_IMAGE_PATH);
    }
}
