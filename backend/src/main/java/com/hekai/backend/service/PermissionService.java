package com.hekai.backend.service;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.entity.PermissionList;
import com.hekai.backend.entity.RelationRolePermission;
import com.hekai.backend.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PermissionService {
    ServerResponse<Page<Role>> getRoleListPageable(Pageable pageable);

    ServerResponse<List<PermissionList>> getPermissionsOgRole(Integer roleId);

    ServerResponse<List<PermissionList>> getAllPermissionsList();

    ServerResponse<String> addPermissionToRole(RelationRolePermission relationRolePermission);

    ServerResponse<String> deletePermissionToRole(RelationRolePermission relationRolePermission);

    ServerResponse<Role> addRole(Role role);

    ServerResponse<Role> deleteRole(Role role);
}
