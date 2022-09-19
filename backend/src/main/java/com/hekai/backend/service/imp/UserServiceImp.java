package com.hekai.backend.service.imp;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.TimeAndCountDto;
import com.hekai.backend.entity.EmployeeUser;
import com.hekai.backend.entity.User;
import com.hekai.backend.repository.EmployeeUserRepository;
import com.hekai.backend.repository.UserRepository;
import com.hekai.backend.service.UserService;
import com.hekai.backend.utils.ConstUtil;
import com.hekai.backend.utils.DateFormatUtil;
import com.hekai.backend.utils.RegexUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmployeeUserRepository employeeUserRepository;

    /**
     * 登录
     *
     * @param account  账户
     * @param password 密码
     * @return {@link ServerResponse}<{@link User}>
     */
    @Override
    public ServerResponse<User> login(String account, String password) {
        RegexUtil.AccountType type=RegexUtil.getAccountType(account);
        User user = null;
        if(type == RegexUtil.AccountType.PHONE_NUMBER){
            user=userRepository.findUserByPhoneNumber(account);
        }
        else if(type == RegexUtil.AccountType.EMAIL){
            user=userRepository.findUserByEmail(account);
        }else if(type== RegexUtil.AccountType.UN_KNOW){
            return ServerResponse.createByErrorMessage("账号格式错误！");
        }
        if(user==null){
            return ServerResponse.createByErrorMessage("无此用户！");
        }else{
            if(user.getPassword().equals(password)){
                user.setLastLoginTime(new Timestamp(new Date().getTime()));
                User result=userRepository.save(user);
                result.hidePassword();
                return ServerResponse.createRespBySuccess(result);
            }else{
                return ServerResponse.createByErrorMessage("密码错误！");
            }
        }
    }

    @Override
    public ServerResponse<User> findUserById(int id) {
        User user= userRepository.findUserById(id);
        return ServerResponse.createRespBySuccess(user);
    }

    @Override
    public ServerResponse<User> updateUserInfo(User user) {
        if(user.getPhoneNumber()==null){
            return ServerResponse.createByErrorMessage("手机号不能为空！");
        }
        if(user.getEmail()==null){
            return ServerResponse.createByErrorMessage("邮箱不能为空！");
        }
        if(userRepository.findUserByPhoneNumber(user.getPhoneNumber())!=null){
            return ServerResponse.createByErrorMessage("手机号已被注册！");
        }
        if(userRepository.findUserByEmail(user.getEmail())!=null){
            return ServerResponse.createByErrorMessage("邮箱已被注册！");
        }
        User result=userRepository.save(user);
        result.hidePassword();
        return ServerResponse.createRespBySuccess(result);
    }

    @Override
    public ServerResponse<User> save(User user) {
        if(RegexUtil.getAccountType(user.getPhoneNumber())!= RegexUtil.AccountType.PHONE_NUMBER){
            return ServerResponse.createByErrorMessage("手机号格式错误！");
        }
        if(userRepository.findUserByPhoneNumber(user.getPhoneNumber())!=null){
            return ServerResponse.createByErrorMessage("手机号已被注册！");
        }
        if(RegexUtil.getAccountType(user.getEmail())!= RegexUtil.AccountType.EMAIL){
            return ServerResponse.createByErrorMessage("邮箱格式错误！");
        }
        if(userRepository.findUserByEmail(user.getEmail())!=null){
            return ServerResponse.createByErrorMessage("邮箱已被注册！");
        }
        user.setRegisterTime(new Timestamp(new Date().getTime()));
        User result=userRepository.save(user);
        return ServerResponse.createRespBySuccess(result);
    }

    @Override
    public ServerResponse<String> checkRegisterInfo(String info) {
        RegexUtil.AccountType type=RegexUtil.getAccountType(info);
        if(type== RegexUtil.AccountType.PHONE_NUMBER){
            User user= userRepository.findUserByPhoneNumber(info);
            if(user==null){
                return ServerResponse.createRespBySuccessMessage("手机号可以使用！");
            }else{
                return ServerResponse.createByErrorMessage("手机号已被使用");
            }
        }else if(type== RegexUtil.AccountType.EMAIL){
            User user= userRepository.findUserByEmail(info);
            if(user==null){
                return ServerResponse.createRespBySuccessMessage("邮箱号可以使用！");
            }else{
                return ServerResponse.createByErrorMessage("邮箱号已被使用！");
            }
        }else {
            return ServerResponse.createByErrorMessage("不符合格式！");
        }
    }

    @Override
    public ServerResponse<EmployeeUser> adminLogin(String account, String password) {
        EmployeeUser employeeUser=employeeUserRepository.findEmployeeUserByNumber(account);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("用户不存在！");
        }
        if(!employeeUser.getPassword().equals(password)){
            return ServerResponse.createByErrorMessage("密码错误！");
        }else{
            employeeUser.hidePassword();
            return ServerResponse.createRespBySuccess(employeeUser);
        }
    }

    @Override
    public ServerResponse<Page<User>> getAllUser(Pageable pageable) {
        Page<User> users=userRepository.findAll(pageable);
        users.getContent().forEach(User::hidePassword);
        return ServerResponse.createRespBySuccess(users);
    }

    @Override
    public ServerResponse<User> updateUserInfoById(Integer userId) {
        User user= userRepository.findUserById(userId);
        return updateUserInfo(user);
    }

    @Override
    public ServerResponse<String> deleteUser(Integer userId) {
        User user= userRepository.findUserById(userId);
        user.setStatus(0);
        save(user);
        return ServerResponse.createRespBySuccess();
    }

    @Override
    public ServerResponse<Page<EmployeeUser>> findEmployeeUserListPageable(Pageable pageable,Integer storeId) {
        Page<EmployeeUser> employeeUsers=employeeUserRepository.findEmployeeUsersByStoreIdAndRoleIdNot(pageable,storeId, ConstUtil.SUPER_ADMIN_ROLE);
        return ServerResponse.createRespBySuccess(employeeUsers);
    }

    @Override
    public ServerResponse<EmployeeUser> createEmployeeUser(EmployeeUser creator, EmployeeUser employeeUser) {
        if(employeeUser.getNumber()==null){
            return ServerResponse.createByErrorMessage("员工号不能为空！");
        }
        EmployeeUser temp = employeeUserRepository.findEmployeeUserByNumber(employeeUser.getNumber());
        if(temp!=null){
            return ServerResponse.createByErrorMessage("该员工号已存在！");
        }
        Timestamp timestamp=new Timestamp(new Date().getTime());
        employeeUser.setCreatedTime(timestamp);
        employeeUser.setCreator(creator.getName());
        return ServerResponse.createRespBySuccess(employeeUserRepository.save(employeeUser));
    }

    @Override
    public ServerResponse<String> deleteEmployeeUser(EmployeeUser operator, EmployeeUser employeeUser) {
        EmployeeUser waitForDelete = employeeUserRepository.findEmployeeUserById(employeeUser.getId());
        waitForDelete.setEnabled((byte)0);
        Timestamp timestamp=new Timestamp(new Date().getTime());
        employeeUser.setUpdatedTime(timestamp);
        employeeUser.setUpdater(operator.getName());
        employeeUserRepository.save(waitForDelete);
        return ServerResponse.createRespBySuccessMessage("删除成功！");
    }

    @Override
    public ServerResponse<EmployeeUser> updateEmployeeAccount(EmployeeUser operator, EmployeeUser employeeUser) {
        employeeUser.setUpdatedTime(new Timestamp(new Date().getTime()));
        employeeUser.setUpdater(operator.getName());
        return ServerResponse.createRespBySuccess(employeeUserRepository.save(employeeUser));
    }

    @Override
    public ServerResponse<EmployeeUser> employeeLogin(String account, String password) {
        return adminLogin(account,password);
    }

    @Override
    public ServerResponse<String> forgetPassword(String account, String oldPassword, String newPassword) {
        if(account==null){
            return ServerResponse.createByErrorMessage("账号不能为空！");
        }
        User user;
        if(RegexUtil.getAccountType(account)==RegexUtil.AccountType.PHONE_NUMBER){
            user=userRepository.findUserByPhoneNumber(account);
            if(user==null){
                return ServerResponse.createByErrorMessage("该手机号未注册！");
            }
        }else if(RegexUtil.getAccountType(account)==RegexUtil.AccountType.EMAIL) {
            user = userRepository.findUserByEmail(account);
            if (user == null) {
                return ServerResponse.createByErrorMessage("该邮箱未注册！");
            }
        }else{
            return ServerResponse.createByErrorMessage("账号格式不正确！");
        }
        if(!user.getPassword().equals(oldPassword)){
            return ServerResponse.createByErrorMessage("原密码错误！");
        }
        user.setPassword(newPassword);
        userRepository.save(user);
        return ServerResponse.createRespBySuccessMessage("修改成功！");
    }

    @Override
    public ServerResponse<List<TimeAndCountDto>> getRegisterUserByDate(Integer days) {
        Date now=new Date();
        List<TimeAndCountDto> list=new ArrayList<>();
        for(int i=0;i<days;++i){
            Date date= DateUtils.addDays(now,-i);
            Date start=DateUtils.truncate(date, Calendar.DATE);
            Date end=DateUtils.addMilliseconds(DateUtils.ceiling(date,Calendar.DATE),-1);

            int count=userRepository.countByRegisterTimeBetween(start,end);
            TimeAndCountDto timeAndCountDto=new TimeAndCountDto();
            timeAndCountDto.setTime(DateFormatUtil.formatDate(date));
            timeAndCountDto.setCount(count);
            list.add(timeAndCountDto);
        }
        return ServerResponse.createRespBySuccess(list);
    }

    @Override
    public ServerResponse<Page<EmployeeUser>> findOnlyEmployeeUserPageableByStoreId(Pageable pageable, Integer storeId) {
        List<Integer> roleList=new ArrayList<>();
        roleList.add(ConstUtil.EMPLOYEE_ROLE);
        roleList.add(ConstUtil.FINANCIAL_DIRECTOR);
        Page<EmployeeUser> employeeUsers=employeeUserRepository.findEmployeeUsersByStoreIdAndRoleIdIn(pageable,storeId,roleList);
        return ServerResponse.createRespBySuccess(employeeUsers);
    }

    @Override
    public ServerResponse<List<EmployeeUser>> getAllStoreManager() {
        List<EmployeeUser> employeeUsers=employeeUserRepository.findEmployeeUsersByRoleId(ConstUtil.STORE_MANAGER);
        return ServerResponse.createRespBySuccess(employeeUsers);
    }

    @Override
    public ServerResponse<List<EmployeeUser>> getAllFreeStoreManager() {
        List<EmployeeUser> employeeUsers=employeeUserRepository.findEmployeeUsersByRoleId(ConstUtil.STORE_MANAGER);
        List<EmployeeUser> freeEmployeeUsers=new ArrayList<>();
        for(EmployeeUser employeeUser:employeeUsers){
            if(employeeUser.getStoreId()==null){
                freeEmployeeUsers.add(employeeUser);
            }
        }
        return ServerResponse.createRespBySuccess(freeEmployeeUsers);
    }

    @Override
    public ServerResponse<List<EmployeeUser>> getAllFreeEmployee() {
        List<EmployeeUser> employeeUsers=employeeUserRepository.findEmployeeUsersByRoleId(ConstUtil.EMPLOYEE_ROLE);
        List<EmployeeUser> freeEmployeeUsers=new ArrayList<>();
        for(EmployeeUser employeeUser:employeeUsers){
            if(employeeUser.getStoreId()==null){
                freeEmployeeUsers.add(employeeUser);
            }
        }
        return ServerResponse.createRespBySuccess(freeEmployeeUsers);
    }

    @Override
    public ServerResponse<String> setEmployeeToStore(String employeeUserNumber, Integer storeId) {
        EmployeeUser employeeUser=employeeUserRepository.findEmployeeUserByNumber(employeeUserNumber);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("该员工不存在！");
        }
        if(employeeUser.getStoreId()!=null){
            return ServerResponse.createByErrorMessage("该员工已经在其他门店！");
        }
        employeeUser.setStoreId(storeId);
        employeeUserRepository.save(employeeUser);
        return ServerResponse.createRespBySuccessMessage("设置成功！");
    }

    @Override
    public ServerResponse<String> deleteEmployeeToStore(String employeeUserNumber, Integer storeId) {
        EmployeeUser employeeUser=employeeUserRepository.findEmployeeUserByNumber(employeeUserNumber);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("该员工不存在！");
        }
        if(employeeUser.getStoreId()==null){
            return ServerResponse.createByErrorMessage("该员工不在任何门店！");
        }
        if(!employeeUser.getStoreId().equals(storeId)){
            return ServerResponse.createByErrorMessage("该员工不在该门店！");
        }
        employeeUser.setStoreId(null);
        employeeUserRepository.save(employeeUser);
        return ServerResponse.createRespBySuccessMessage("删除成功！");
    }

    @Override
    public ServerResponse<EmployeeUser> getEmployeeUserByEmployeeId(Integer employeeId) {
        EmployeeUser employeeUser=employeeUserRepository.findEmployeeUserById(employeeId);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("该员工不存在！");
        }
        employeeUser.hidePassword();
        return ServerResponse.createRespBySuccess(employeeUser);
    }
}
