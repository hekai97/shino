package com.hekai.backend.controller.backstage;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.entity.EmployeeUser;
import com.hekai.backend.entity.User;
import com.hekai.backend.service.UserService;
import com.hekai.backend.utils.ConstUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/admin/user")
public class AdminUserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ServerResponse<EmployeeUser> login(HttpSession httpSession, String account, String password){
        ServerResponse<EmployeeUser> response=userService.adminLogin(account,password);
        if(response.isSuccess()){
            httpSession.setAttribute(ConstUtil.ADMIN_USER,response.getData());
            httpSession.setMaxInactiveInterval(30*60);
        }
        return response;
    }

    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public ServerResponse<String> logout(HttpSession httpSession){
        httpSession.removeAttribute(ConstUtil.ADMIN_USER);
        return ServerResponse.createRespBySuccess();
    }

    @RequestMapping(value = "/getAllUserPageable",method = RequestMethod.POST)
    public ServerResponse<Page<User>> getAllUser(HttpSession httpSession, Pageable pageable){
        EmployeeUser user=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(user==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return userService.getAllUser(pageable);
    }
    @RequestMapping(value = "/getUserById",method = RequestMethod.POST)
    public ServerResponse<User> getUserById(HttpSession httpSession,Integer userId){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return userService.findUserById(userId);
    }
    @RequestMapping(value = "/updateUserInfo",method = RequestMethod.POST)
    public ServerResponse<User> updateUserInfo(HttpSession httpSession,Integer userId){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return userService.updateUserInfoById(userId);
    }
    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST)
    public ServerResponse<String> deleteUser(HttpSession httpSession,Integer userId){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return userService.deleteUser(userId);
    }

    //////////////////////////////////////////////////////////////////////////////////////////

    @RequestMapping(value = "/getEmployeeUserListPageable",method = RequestMethod.POST)
    public ServerResponse<Page<EmployeeUser>> getEmployeeUserListPageable(HttpSession httpSession,Pageable pageable){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return userService.findEmployeeUserListPageable(pageable);
    }
    @RequestMapping(value = "/createEmployeeAccount",method = RequestMethod.POST)
    public ServerResponse<EmployeeUser> createEmployeeAccount(HttpSession httpSession,EmployeeUser employeeUser){
        EmployeeUser curUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(curUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return userService.createEmployeeUser(curUser,employeeUser);
    }
    @RequestMapping(value = "/deleteEmployeeAccount",method = RequestMethod.POST)
    public ServerResponse<String> deleteEmployeeAccount(HttpSession httpSession,EmployeeUser employeeUser){
        EmployeeUser curUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(curUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return userService.deleteEmployeeUser(curUser,employeeUser);
    }
    @RequestMapping(value = "/updateEmployeeAccount",method = RequestMethod.POST)
    public ServerResponse<EmployeeUser> updateEmployeeAccount(HttpSession httpSession,EmployeeUser employeeUser){
        EmployeeUser curUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(curUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return userService.updateEmployeeAccount(curUser,employeeUser);
    }
}
