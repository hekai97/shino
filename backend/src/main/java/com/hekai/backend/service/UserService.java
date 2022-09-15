package com.hekai.backend.service;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.TimeAndCountDto;
import com.hekai.backend.entity.EmployeeUser;
import com.hekai.backend.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * 用户服务
 *
 * @author 17316
 * @date 2022/09/05
 */
public interface UserService {
    /**
     * 登录
     *
     * @param account  账户
     * @param password 密码
     * @return {@link ServerResponse}<{@link User}>
     */
    ServerResponse<User> login(String account, String password);

    /**
     * 找到用户id
     *
     * @param id id
     * @return {@link ServerResponse}<{@link User}>
     */
    ServerResponse<User> findUserById(int id);

    /**
     * 更新用户信息
     *
     * @param user 用户
     * @return {@link ServerResponse}<{@link User}>
     */
    ServerResponse<User> updateUserInfo(User user);

    /**
     * 保存
     *
     * @param user 用户
     * @return {@link ServerResponse}<{@link User}>
     */
    ServerResponse<User> save(User user);

    /**
     * 检查注册信息
     *
     * @param info 信息
     * @return {@link ServerResponse}<{@link String}>
     */
    ServerResponse<String> checkRegisterInfo(String info);

    /**
     * 管理员登录
     *
     * @param account  账户
     * @param password 密码
     * @return {@link ServerResponse}<{@link EmployeeUser}>
     */
    ServerResponse<EmployeeUser> adminLogin(String account, String password);

    /**
     * 让所有用户
     *
     * @param pageable 可分页
     * @return {@link ServerResponse}<{@link Page}<{@link User}>>
     */
    ServerResponse<Page<User>> getAllUser(Pageable pageable);

    /**
     * 更新用户信息通过id
     *
     * @param userId 用户id
     * @return {@link ServerResponse}<{@link User}>
     */
    ServerResponse<User> updateUserInfoById(Integer userId);

    /**
     * 删除用户
     *
     * @param userId 用户id
     * @return {@link ServerResponse}<{@link String}>
     */
    ServerResponse<String> deleteUser(Integer userId);

    /**
     * 发现员工用户列表可分页
     *
     * @param pageable 可分页
     * @return {@link ServerResponse}<{@link Page}<{@link EmployeeUser}>>
     */
    ServerResponse<Page<EmployeeUser>> findEmployeeUserListPageable(Pageable pageable,Integer storeId);

    /**
     * 创建员工用户
     *
     * @param creator      创造者
     * @param employeeUser 员工用户
     * @return {@link ServerResponse}<{@link EmployeeUser}>
     */
    ServerResponse<EmployeeUser> createEmployeeUser(EmployeeUser creator, EmployeeUser employeeUser);

    /**
     * 删除员工用户
     *
     * @param operator     操作符
     * @param employeeUser 员工用户
     * @return {@link ServerResponse}<{@link String}>
     */
    ServerResponse<String> deleteEmployeeUser(EmployeeUser operator, EmployeeUser employeeUser);

    /**
     * 更新员工账户
     *
     * @param operator     操作符
     * @param employeeUser 员工用户
     * @return {@link ServerResponse}<{@link EmployeeUser}>
     */
    ServerResponse<EmployeeUser> updateEmployeeAccount(EmployeeUser operator, EmployeeUser employeeUser);

    /**
     * 员工登录
     *
     * @param account  账户
     * @param password 密码
     * @return {@link ServerResponse}<{@link EmployeeUser}>
     */
    ServerResponse<EmployeeUser> employeeLogin(String account, String password);

    /**
     * 忘记密码
     *
     * @param account     账户
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return {@link ServerResponse}<{@link String}>
     */
    ServerResponse<String> forgetPassword(String account, String oldPassword, String newPassword);

    /**
     * 让注册用户按日期
     *
     * @param days 天
     * @return {@link ServerResponse}<{@link Map}<{@link String}, {@link Integer}>>
     */
    ServerResponse<List<TimeAndCountDto>> getRegisterUserByDate(Integer days);

    ServerResponse<Page<EmployeeUser>> findOnlyEmployeeUserPageableByStoreId(Pageable pageable, Integer storeId);
}
