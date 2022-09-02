package com.hekai.backend.controller.employee;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.entity.BasicUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/employee/user")
public class EmployeeUserController {
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ServerResponse<BasicUser> login(HttpSession httpSession,String account,String password){
        return null;
    }
}
