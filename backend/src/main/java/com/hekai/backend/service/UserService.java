package com.hekai.backend.service;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.entity.EmployeeUser;
import com.hekai.backend.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    ServerResponse<User> login(String account, String password);

    ServerResponse<User> findUserById(int id);

    ServerResponse<User> updateUserInfo(User user);

    ServerResponse<User> save(User user);

    ServerResponse<String> checkRegisterInfo(String info);

    ServerResponse<EmployeeUser> adminLogin(String account, String password);

    ServerResponse<Page<User>> getAllUser(Pageable pageable);

    ServerResponse<User> updateUserInfoById(Integer userId);

    ServerResponse<String> deleteUser(Integer userId);
}
