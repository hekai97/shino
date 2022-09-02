package com.hekai.backend.controller.client;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.entity.BasicStudent;
import com.hekai.backend.service.BasicStudentService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private BasicStudentService basicStudentService;

    /**
     * 登录
     *
     * @param httpSession http会话
     * @param account     账户
     * @param password    密码
     * @return {@link ServerResponse}<{@link BasicStudent}>
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ServerResponse<BasicStudent> login(HttpSession httpSession,String account,String password){
        return null;
    }

    /**
     * 注册
     *
     * @param basicStudent 基本学生
     * @return {@link ServerResponse}<{@link BasicStudent}>
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ServerResponse<BasicStudent> register(BasicStudent basicStudent){
        return null;
    }

    /**
     * 检查注册信息
     *
     * @param info 信息
     * @param type 类型,phone/email
     * @return {@link ServerResponse}<{@link String}>
     */
    @RequestMapping(value = "/checkRegisterInfo",method = RequestMethod.POST)
    ServerResponse<String> checkRegisterInfo(String info,String type){
        return null;
    }
    /**
     * 获取登录信息
     *
     * @param httpSession http会话
     * @return {@link ServerResponse}<{@link BasicStudent}>
     */
    @RequestMapping(value = "/getLoginInfo",method = RequestMethod.GET)
    public ServerResponse<BasicStudent> getLoginInfo(HttpSession httpSession){
        return null;
    }

    /**
     * 获取用户信息
     *
     * @param httpSession http会话
     * @return {@link ServerResponse}<{@link BasicStudent}>
     */
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.GET)
    public ServerResponse<BasicStudent> getUserInfo(HttpSession httpSession){
        return null;
    }

    /**
     * 更新用户信息
     *
     * @param httpSession  http会话
     * @param basicStudent 基本学生
     * @return {@link ServerResponse}<{@link BasicStudent}>
     */
    @RequestMapping(value = "updateUserInfo",method = RequestMethod.POST)
    public ServerResponse<BasicStudent> updateUserInfo(HttpSession httpSession,BasicStudent basicStudent){
        return null;
    }
}
