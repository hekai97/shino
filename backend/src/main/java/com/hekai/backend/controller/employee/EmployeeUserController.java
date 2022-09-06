package com.hekai.backend.controller.employee;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.entity.EmployeeUser;
import com.hekai.backend.service.UserService;
import com.hekai.backend.utils.ConstUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 员工用户控制器
 *
 * @author 17316
 * @date 2022/09/06
 */
@RestController
@RequestMapping(value = "/employee/user")
public class EmployeeUserController {
    @Autowired
    private UserService userService;

    /**
     * 登录
     *
     * @param httpSession http会话
     * @param account     账户
     * @param password    密码
     * @return {@link ServerResponse}<{@link EmployeeUser}>
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ServerResponse<EmployeeUser> login(HttpSession httpSession, String account, String password){
        ServerResponse<EmployeeUser> response=userService.employeeLogin(account,password);
        if(response.isSuccess()){
            httpSession.setAttribute(ConstUtil.EMPLOYEE_USER,response.getData());
            httpSession.setMaxInactiveInterval(30*60);
        }
        return response;
    }

    /**
     * 注销
     *
     * @param httpSession http会话
     * @return {@link ServerResponse}<{@link String}>
     */
    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public ServerResponse<String> logout(HttpSession httpSession){
        httpSession.removeAttribute(ConstUtil.EMPLOYEE_USER);
        return ServerResponse.createRespBySuccess();
    }
}
