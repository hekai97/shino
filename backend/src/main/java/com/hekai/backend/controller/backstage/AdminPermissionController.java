package com.hekai.backend.controller.backstage;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.entity.EmployeeUser;
import com.hekai.backend.entity.PermissionList;
import com.hekai.backend.entity.RelationRolePermission;
import com.hekai.backend.entity.Role;
import com.hekai.backend.service.PermissionService;
import com.hekai.backend.utils.ConstUtil;
import io.swagger.v3.oas.annotations.Parameter;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 管理权限控制器
 *
 * @author 17316
 * @date 2022/09/06
 */
@RestController
@RequestMapping(value = "/admin/permission")
public class AdminPermissionController {
    @Autowired
    private PermissionService permissionService;

    /**
     * 获取角色列表可分页
     *
     * @param httpSession http会话
     * @param pageable    可分页
     * @return {@link ServerResponse}<{@link Page}<{@link Role}>>
     */
    @RequestMapping(value = "/getRoleListPageable",method = RequestMethod.GET)
    public ServerResponse<Page<Role>> getRoleListPageable(HttpSession httpSession, @ParameterObject Pageable pageable){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return permissionService.getRoleListPageable(pageable);
    }

    /**
     * 获得许可作用
     *
     * @param httpSession http会话
     * @param roleId      角色id
     * @return {@link ServerResponse}<{@link List}<{@link PermissionList}>>
     */
    @RequestMapping(value = "/getPermissionOfRole",method = RequestMethod.GET)
    public ServerResponse<List<PermissionList>> getPermissionOfRole(HttpSession httpSession,@Parameter Integer roleId){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return permissionService.getPermissionsOgRole(roleId);
    }

    /**
     * 获得所有许可列表
     *
     * @param httpSession http会话
     * @return {@link ServerResponse}<{@link List}<{@link PermissionList}>>
     */
    @RequestMapping(value = "/getAllPermissionList",method = RequestMethod.GET)
    public ServerResponse<List<PermissionList>> getAllPermissionList(HttpSession httpSession){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return permissionService.getAllPermissionsList();
    }

    /**
     * 更新权限角色
     *
     * @param httpSession            http会话
     * @param relationRolePermission 角色权限关系
     * @return {@link ServerResponse}<{@link String}>
     */
    @RequestMapping(value = "/addPermissionToRole",method = RequestMethod.POST)
    public ServerResponse<String> updatePermissionToRole(HttpSession httpSession, @RequestBody RelationRolePermission relationRolePermission){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return permissionService.addPermissionToRole(relationRolePermission);
    }

    /**
     * 删除权限角色
     *
     * @param httpSession            http会话
     * @param relationRolePermission 角色权限关系
     * @return {@link ServerResponse}<{@link String}>
     */
    @RequestMapping(value = "/deletePermissionToRole",method = RequestMethod.POST)
    public ServerResponse<String> deletePermissionToRole(HttpSession httpSession,@RequestBody RelationRolePermission relationRolePermission){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return permissionService.deletePermissionToRole(relationRolePermission);
    }

    /**
     * 添加角色
     *
     * @param httpSession http会话
     * @param role        角色
     * @return {@link ServerResponse}<{@link Role}>
     */
    @RequestMapping(value = "/addRole",method = RequestMethod.POST)
    public ServerResponse<Role> addRole(HttpSession httpSession,@RequestBody Role role){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return permissionService.addRole(role);
    }

    /**
     * 删除角色
     *
     * @param httpSession http会话
     * @param role        角色
     * @return {@link ServerResponse}<{@link Role}>
     */
    @RequestMapping(value = "/deleteRole",method = RequestMethod.POST)
    public ServerResponse<Role> deleteRole(HttpSession httpSession,@RequestBody Role role){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return permissionService.deleteRole(role);
    }
}
