package com.hekai.backend.controller.client;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.entity.User;
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

    // @Autowired
    // private UserService UserService;


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
        return null;
    }

    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public ServerResponse<String> logout(HttpSession httpSession){
        return null;
    }

    /**
     * 注册
     *
     * @param User 用户
     * @return {@link ServerResponse}<{@link User}>
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ServerResponse<User> register(User User){
        return null;
    }

    /**
     * 检查注册信息
     *
     * @param info 信息
     * @param type 类型
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
     * @return {@link ServerResponse}<{@link User}>
     */
    @RequestMapping(value = "/getLoginInfo",method = RequestMethod.GET)
    public ServerResponse<User> getLoginInfo(HttpSession httpSession){
        return null;
    }

    /**
     * 获取用户信息
     *
     * @param httpSession http会话
     * @return {@link ServerResponse}<{@link User}>
     */
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
    public ServerResponse<User> getUserInfo(HttpSession httpSession){
        return null;
    }

    /**
     * 更新用户信息
     *
     * @param httpSession http会话
     * @param User        用户
     * @return {@link ServerResponse}<{@link User}>
     */
    @RequestMapping(value = "updateUserInfo",method = RequestMethod.POST)
    public ServerResponse<User> updateUserInfo(HttpSession httpSession, User User){
        return null;
    }
}
