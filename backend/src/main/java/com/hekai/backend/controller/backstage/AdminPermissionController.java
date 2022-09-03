package com.hekai.backend.controller.backstage;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.entity.EmployeeUser;
import com.hekai.backend.entity.PermissionList;
import com.hekai.backend.entity.Role;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/admin/permission")
public class AdminPermissionController {
    @RequestMapping(value = "/getRoleListPageable",method = RequestMethod.GET)
    public ServerResponse<List<Role>> getRoleListPageable(HttpSession httpSession,Integer pageSize,Integer pageNumber){
        return null;
    }
    @RequestMapping(value = "/getPermissionOfRole",method = RequestMethod.GET)
    public ServerResponse<List<PermissionList>> getPermissionOfRole(HttpSession httpSession,Integer roleId){
        return null;
    }
    @RequestMapping(value = "/getPermissionList",method = RequestMethod.GET)
    public ServerResponse<List<PermissionList>> getPermissionList(HttpSession httpSession){
        return null;
    }
    @RequestMapping(value = "/addPermissionToRole",method = RequestMethod.POST)
    public ServerResponse<List<PermissionList>> updatePermissionToRole(HttpSession httpSession,Integer roleId,Integer permissionId){
        return null;
    }
    @RequestMapping(value = "/deletePermissionToRole",method = RequestMethod.POST)
    public ServerResponse<List<PermissionList>> deletePermissionToRole(HttpSession httpSession,Integer roleId,Integer permissionId){
        return null;
    }
    @RequestMapping(value = "/addRole",method = RequestMethod.POST)
    public ServerResponse<Role> addRole(HttpSession httpSession,Role role){
        return null;
    }
    @RequestMapping(value = "/deleteRole",method = RequestMethod.POST)
    public ServerResponse<Role> deleteRole(HttpSession httpSession,Role role){
        return null;
    }
    @RequestMapping(value = "/getEmployeeUserListPageable",method = RequestMethod.POST)
    public ServerResponse<List<EmployeeUser>> getEmployeeUserListPageable(HttpSession httpSession,Integer pageSize,Integer pageNumber){
        return null;
    }
    @RequestMapping(value = "/createEmployeeAccount",method = RequestMethod.POST)
    public ServerResponse<EmployeeUser> createEmployeeAccount(HttpSession httpSession,EmployeeUser employeeUser){
        return null;
    }
    @RequestMapping(value = "/deleteEmployeeAccount",method = RequestMethod.POST)
    public ServerResponse<String> deleteEmployeeAccount(HttpSession httpSession,EmployeeUser employeeUser){
        return null;
    }
    @RequestMapping(value = "/updateEmployeeAccount",method = RequestMethod.POST)
    public ServerResponse<EmployeeUser> updateEmployeeAccount(HttpSession httpSession,EmployeeUser employeeUser){
        return null;
    }
}
