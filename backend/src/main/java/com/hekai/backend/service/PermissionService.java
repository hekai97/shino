package com.hekai.backend.service;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.entity.PermissionList;
import com.hekai.backend.entity.RelationRolePermission;
import com.hekai.backend.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 许可服务
 *
 * @author 17316
 * @date 2022/09/06
 */
public interface PermissionService {
    /**
     * 获取角色列表可分页
     *
     * @param pageable 可分页
     * @return {@link ServerResponse}<{@link Page}<{@link Role}>>
     */
    ServerResponse<Page<Role>> getRoleListPageable(Pageable pageable);

    /**
     * 获得权限og作用
     *
     * @param roleId 角色id
     * @return {@link ServerResponse}<{@link List}<{@link PermissionList}>>
     */
    ServerResponse<List<PermissionList>> getPermissionsOgRole(Integer roleId);

    /**
     * 得到所有权限列表
     *
     * @return {@link ServerResponse}<{@link List}<{@link PermissionList}>>
     */
    ServerResponse<List<PermissionList>> getAllPermissionsList();

    /**
     * 添加权限角色
     *
     * @param relationRolePermission 角色权限关系
     * @return {@link ServerResponse}<{@link String}>
     */
    ServerResponse<String> addPermissionToRole(RelationRolePermission relationRolePermission);

    /**
     * 删除权限角色
     *
     * @param relationRolePermission 角色权限关系
     * @return {@link ServerResponse}<{@link String}>
     */
    ServerResponse<String> deletePermissionToRole(RelationRolePermission relationRolePermission);

    /**
     * 添加角色
     *
     * @param role 角色
     * @return {@link ServerResponse}<{@link Role}>
     */
    ServerResponse<Role> addRole(Role role);

    /**
     * 删除角色
     *
     * @param role 角色
     * @return {@link ServerResponse}<{@link Role}>
     */
    ServerResponse<Role> deleteRole(Role role);
}
