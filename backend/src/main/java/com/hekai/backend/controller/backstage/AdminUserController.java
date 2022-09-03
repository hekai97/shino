package com.hekai.backend.controller.backstage;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/admin/user")
public class AdminUserController {
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ServerResponse<User> login(HttpSession httpSession, String account, String password){
        return null;
    }

    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public ServerResponse<String> logout(HttpSession httpSession){
        return null;
    }

    @RequestMapping(value = "/getAllUserPageable",method = RequestMethod.POST)
    public ServerResponse<List<User>> getAllUser(HttpSession httpSession, Integer pageSize, Integer pageNumber){
        return null;
    }
    @RequestMapping(value = "/getUserById",method = RequestMethod.POST)
    public ServerResponse<User> getUserById(HttpSession httpSession,Integer userId){
        return null;
    }
    @RequestMapping(value = "/updateUserInfo",method = RequestMethod.POST)
    public ServerResponse<User> updateUserInfo(HttpSession httpSession,Integer userId){
        return null;
    }
    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST)
    public ServerResponse<String> deleteUser(HttpSession httpSession,Integer userId){
        return null;
    }
}
