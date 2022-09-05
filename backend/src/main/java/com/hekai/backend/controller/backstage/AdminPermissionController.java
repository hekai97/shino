package com.hekai.backend.controller.backstage;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.entity.EmployeeUser;
import com.hekai.backend.entity.PermissionList;
import com.hekai.backend.entity.RelationRolePermission;
import com.hekai.backend.entity.Role;
import com.hekai.backend.service.PermissionService;
import com.hekai.backend.utils.ConstUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/admin/permission")
public class AdminPermissionController {
    @Autowired
    private PermissionService permissionService;
    @RequestMapping(value = "/getRoleListPageable",method = RequestMethod.GET)
    public ServerResponse<Page<Role>> getRoleListPageable(HttpSession httpSession, Pageable pageable){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return permissionService.getRoleListPageable(pageable);
    }
    @RequestMapping(value = "/getPermissionOfRole",method = RequestMethod.GET)
    public ServerResponse<List<PermissionList>> getPermissionOfRole(HttpSession httpSession,Integer roleId){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return permissionService.getPermissionsOgRole(roleId);
    }
    @RequestMapping(value = "/getAllPermissionList",method = RequestMethod.GET)
    public ServerResponse<List<PermissionList>> getAllPermissionList(HttpSession httpSession){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return permissionService.getAllPermissionsList();
    }
    @RequestMapping(value = "/addPermissionToRole",method = RequestMethod.POST)
    public ServerResponse<String> updatePermissionToRole(HttpSession httpSession, RelationRolePermission relationRolePermission){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return permissionService.addPermissionToRole(relationRolePermission);
    }
    @RequestMapping(value = "/deletePermissionToRole",method = RequestMethod.POST)
    public ServerResponse<String> deletePermissionToRole(HttpSession httpSession,RelationRolePermission relationRolePermission){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return permissionService.deletePermissionToRole(relationRolePermission);
    }
    @RequestMapping(value = "/addRole",method = RequestMethod.POST)
    public ServerResponse<Role> addRole(HttpSession httpSession,Role role){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return permissionService.addRole(role);
    }
    @RequestMapping(value = "/deleteRole",method = RequestMethod.POST)
    public ServerResponse<Role> deleteRole(HttpSession httpSession,Role role){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return permissionService.deleteRole(role);
    }
}
