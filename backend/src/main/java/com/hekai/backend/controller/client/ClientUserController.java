package com.hekai.backend.controller.client;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.entity.User;
import com.hekai.backend.service.UserService;
import com.hekai.backend.utils.ConstUtil;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 客户端用户控制器
 * 客户端用户相关方法
 *
 * @author 17316
 * @date 2022/09/02
 */
@RestController
@RequestMapping(value = "/student")
public class ClientUserController {

     @Autowired
     private UserService userService;


    /**
     * 登录
     *
     * @param httpSession http会话
     * @param account     账户
     * @param password    密码
     * @return {@link ServerResponse}<{@link User}>
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ServerResponse<User> login(HttpSession httpSession,String account,String password){
        System.out.println(account+" "+password);
        ServerResponse<User> response=userService.login(account,password);
        if(response.isSuccess()){
            httpSession.setAttribute(ConstUtil.NORMAL_USER,response.getData());
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
        httpSession.removeAttribute(ConstUtil.NORMAL_USER);
        return ServerResponse.createRespBySuccess();
    }

    /**
     * 注册
     *
     * @param user 用户
     * @return {@link ServerResponse}<{@link User}>
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ServerResponse<User> register(@RequestBody User user){
        return userService.save(user);
    }

    /**
     * 检查注册信息
     *
     * @param info 信息
     * @return {@link ServerResponse}<{@link String}>
     */
    @Operation(summary = "该接口中的info可以传递手机号或者电子邮箱帐号")
    @RequestMapping(value = "/checkRegisterInfo",method = RequestMethod.POST)
    ServerResponse<String> checkRegisterInfo(String info){
        return userService.checkRegisterInfo(info);
    }

    /**
     * 获取用户信息
     * 获取用户信息,在修改用户个人信息时候用以及每次跳转页面时候判断用户登录情况
     *
     * @param httpSession http会话
     * @return {@link ServerResponse}<{@link User}>
     */
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
    public ServerResponse<User> getUserInfo(HttpSession httpSession){
        User user=(User) httpSession.getAttribute(ConstUtil.NORMAL_USER);
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登录！");
        }
        ServerResponse<User> response=userService.findUserById(user.getId());
        response.getData().hidePassword();
        return response;
    }

    /**
     * 更新用户信息
     *
     * @param httpSession http会话
     * @param user        用户
     * @return {@link ServerResponse}<{@link User}>
     */
    @RequestMapping(value = "updateUserInfo",method = RequestMethod.POST)
    public ServerResponse<User> updateUserInfo(HttpSession httpSession, @RequestBody User user){
        User currentUser=(User) httpSession.getAttribute(ConstUtil.NORMAL_USER);
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登录！");
        }
        user.setId(currentUser.getId());
        ServerResponse<User> response=userService.updateUserInfo(user);
        if(response.isSuccess()){
            httpSession.setAttribute(ConstUtil.NORMAL_USER,response.getData());
        }
        return response;
    }
}
