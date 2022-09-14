package com.hekai.backend.controller.backstage;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.TimeAndCountDto;
import com.hekai.backend.entity.EmployeeUser;
import com.hekai.backend.entity.User;
import com.hekai.backend.service.UserService;
import com.hekai.backend.utils.ConstUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 管理用户控制器
 *
 * @author 17316
 * @date 2022/09/06
 */
@RestController
@RequestMapping(value = "/admin/user")
public class AdminUserController {
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
    public ServerResponse<EmployeeUser> login(HttpSession httpSession, @Parameter String account, @Parameter String password){
        System.out.println(account+" "+password);
        System.out.println(httpSession.getId());
        ServerResponse<EmployeeUser> response=userService.adminLogin(account,password);
        if(response.isSuccess()){
            httpSession.setAttribute(ConstUtil.ADMIN_USER,response.getData());
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
        httpSession.removeAttribute(ConstUtil.ADMIN_USER);
        return ServerResponse.createRespBySuccess();
    }

    /**
     * 让所有用户
     *
     * @param httpSession http会话
     * @param pageable    可分页
     * @return {@link ServerResponse}<{@link Page}<{@link User}>>
     */
    @RequestMapping(value = "/getAllUserPageable",method = RequestMethod.POST)
    public ServerResponse<Page<User>> getAllUser(HttpSession httpSession, @ParameterObject Pageable pageable){
        EmployeeUser user=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(user==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return userService.getAllUser(pageable);
    }

    /**
     * 得到用户id
     *
     * @param httpSession http会话
     * @param userId      用户id
     * @return {@link ServerResponse}<{@link User}>
     */
    @RequestMapping(value = "/getUserById",method = RequestMethod.POST)
    public ServerResponse<User> getUserById(HttpSession httpSession,@Parameter Integer userId){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return userService.findUserById(userId);
    }

    /**
     * 更新用户信息
     *
     * @param httpSession http会话
     * @param userId      用户id
     * @return {@link ServerResponse}<{@link User}>
     */
    @RequestMapping(value = "/updateUserInfo",method = RequestMethod.POST)
    public ServerResponse<User> updateUserInfo(HttpSession httpSession,@Parameter Integer userId){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return userService.updateUserInfoById(userId);
    }

    /**
     * 删除用户
     *
     * @param httpSession http会话
     * @param userId      用户id
     * @return {@link ServerResponse}<{@link String}>
     */
    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST)
    public ServerResponse<String> deleteUser(HttpSession httpSession,@Parameter Integer userId){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return userService.deleteUser(userId);
    }

    //////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 分页得到员工用户列表
     *
     * @param httpSession http会话
     * @param pageable    可分页
     * @return {@link ServerResponse}<{@link Page}<{@link EmployeeUser}>>
     */
    @RequestMapping(value = "/getEmployeeUserPageableByStoreId",method = RequestMethod.POST)
    public ServerResponse<Page<EmployeeUser>> getEmployeeUserListPageable(HttpSession httpSession,@ParameterObject Pageable pageable,@Parameter Integer storeId){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return userService.findEmployeeUserListPageable(pageable,storeId);
    }

    /**
     * 创建员工帐户
     *
     * @param httpSession  http会话
     * @param employeeUser 员工用户
     * @return {@link ServerResponse}<{@link EmployeeUser}>
     */
    @RequestMapping(value = "/createEmployeeAccount",method = RequestMethod.POST)
    public ServerResponse<EmployeeUser> createEmployeeAccount(HttpSession httpSession,@RequestBody EmployeeUser employeeUser){
        System.out.println(httpSession.getId());
        EmployeeUser curUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(curUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return userService.createEmployeeUser(curUser,employeeUser);
    }

    /**
     * 删除员工账户
     *
     * @param httpSession  http会话
     * @param employeeUser 员工用户
     * @return {@link ServerResponse}<{@link String}>
     */
    @RequestMapping(value = "/deleteEmployeeAccount",method = RequestMethod.POST)
    public ServerResponse<String> deleteEmployeeAccount(HttpSession httpSession,@RequestBody EmployeeUser employeeUser){
        EmployeeUser curUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(curUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return userService.deleteEmployeeUser(curUser,employeeUser);
    }

    /**
     * 更新员工账户
     *
     * @param httpSession  http会话
     * @param employeeUser 员工用户
     * @return {@link ServerResponse}<{@link EmployeeUser}>
     */
    @RequestMapping(value = "/updateEmployeeAccount",method = RequestMethod.POST)
    public ServerResponse<EmployeeUser> updateEmployeeAccount(HttpSession httpSession,@RequestBody EmployeeUser employeeUser){
        EmployeeUser curUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(curUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return userService.updateEmployeeAccount(curUser,employeeUser);
    }

    /**
     * 让注册用户按日期
     *
     * @param httpSession http会话
     * @param days        天
     * @return {@link ServerResponse}<{@link Map}<{@link String},{@link Integer}>>
     */
    @Operation(summary = "获取过去几天注册的人数")
    @RequestMapping(value = "/getRegisterUserByDate",method = RequestMethod.GET)
    public ServerResponse<List<TimeAndCountDto>> getRegisterUserByDate(HttpSession httpSession, @Parameter(description = "这里传入过去几天，默认为7") @Nullable Integer days){
        EmployeeUser curUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(curUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        if(days==null){
            days=7;
        }
        return userService.getRegisterUserByDate(days);
    }
}
