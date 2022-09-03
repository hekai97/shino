package com.hekai.backend.controller.backstage;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.entity.Teacher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/admin/teacher")
public class AdminTeacherController {
    @RequestMapping(value = "/getTeacherListPageable",method = RequestMethod.POST)
    public ServerResponse<List<Teacher>> getTeacherListPageable(HttpSession httpSession,Integer pageSize,Integer pageNumber){
        return null;
    }
    @RequestMapping(value = "/getTeacherByNumber",method = RequestMethod.POST)
    public ServerResponse<Teacher> getTeacherByNumber(HttpSession httpSession,String number){
        return null;
    }
    @RequestMapping(value = "/addTeacher",method = RequestMethod.POST)
    public ServerResponse<Teacher> addTeacher(HttpSession httpSession,Teacher teacher){
        return null;
    }
    @RequestMapping(value = "/updateTeacher",method = RequestMethod.POST)
    public ServerResponse<Teacher> updateTeacher(HttpSession httpSession,Teacher teacher){
        return null;
    }

}
