package com.hekai.backend.controller.backstage;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.TeacherDto;
import com.hekai.backend.entity.EmployeeUser;
import com.hekai.backend.entity.Teacher;
import com.hekai.backend.service.TeacherService;
import com.hekai.backend.utils.ConstUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/admin/teacher")
public class AdminTeacherController {

    @Autowired
    private TeacherService teacherService;
    @RequestMapping(value = "/getTeacherListPageable",method = RequestMethod.POST)
    public ServerResponse<Page<TeacherDto>> getTeacherListPageable(HttpSession httpSession, Pageable pageable){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return teacherService.getTeacherListPageable(pageable);
    }
    @RequestMapping(value = "/getTeacherByNumber",method = RequestMethod.POST)
    public ServerResponse<TeacherDto> getTeacherByNumber(HttpSession httpSession,String number){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return teacherService.getTeacherByNumber(number);
    }
    @RequestMapping(value = "/getTeacherById",method = RequestMethod.POST)
    public ServerResponse<TeacherDto> getTeacherById(HttpSession httpSession,Integer id){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return teacherService.getTeacherById(id);
    }
    @RequestMapping(value = "/addTeacher",method = RequestMethod.POST)
    public ServerResponse<Teacher> addTeacher(HttpSession httpSession,Teacher teacher){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return teacherService.save(teacher);
    }
    @RequestMapping(value = "/updateTeacher",method = RequestMethod.POST)
    public ServerResponse<Teacher> updateTeacher(HttpSession httpSession,Teacher teacher){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return teacherService.updateTeacher(teacher);
    }

}
