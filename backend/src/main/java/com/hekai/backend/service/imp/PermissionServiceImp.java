package com.hekai.backend.service.imp;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.entity.PermissionList;
import com.hekai.backend.entity.RelationRolePermission;
import com.hekai.backend.entity.Role;
import com.hekai.backend.repository.PermissionListRepository;
import com.hekai.backend.repository.RelationRolePermissionRepository;
import com.hekai.backend.repository.RoleRepository;
import com.hekai.backend.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PermissionServiceImp implements PermissionService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PermissionListRepository permissionListRepository;
    @Autowired
    private RelationRolePermissionRepository relationRolePermissionRepository;

    @Override
    public ServerResponse<Page<Role>> getRoleListPageable(Pageable pageable) {
        Page<Role> result=roleRepository.findAll(pageable);
        return ServerResponse.createRespBySuccess(result);
    }

    @Override
    public ServerResponse<List<PermissionList>> getPermissionsOgRole(Integer roleId) {
        List<RelationRolePermission> relationRolePermissions=relationRolePermissionRepository.findRelationRolePermissionsByRoleId(roleId);
        List<PermissionList> result=new ArrayList<>();
        for(RelationRolePermission r:relationRolePermissions){
            PermissionList temp=permissionListRepository.findPermissionListById(r.getPermissionId());
            result.add(temp);
        }
        return ServerResponse.createRespBySuccess(result);
    }

    @Override
    public ServerResponse<List<PermissionList>> getAllPermissionsList() {
        return ServerResponse.createRespBySuccess(permissionListRepository.findAll());
    }

    @Override
    public ServerResponse<String> addPermissionToRole(RelationRolePermission relationRolePermission) {
        relationRolePermissionRepository.save(relationRolePermission);
        return ServerResponse.createRespBySuccessMessage("添加成功");
    }

    @Override
    public ServerResponse<String> deletePermissionToRole(RelationRolePermission relationRolePermission) {
        RelationRolePermission waitDeleteObject=relationRolePermissionRepository.findRelationRolePermissionByRoleIdAndPermissionId(relationRolePermission.getRoleId(), relationRolePermission.getPermissionId());
        relationRolePermissionRepository.delete(waitDeleteObject);
        return ServerResponse.createRespBySuccessMessage("删除成功");
    }

    @Override
    public ServerResponse<Role> addRole(Role role) {
        return ServerResponse.createRespBySuccess(roleRepository.save(role));
    }

    @Override
    public ServerResponse<Role> deleteRole(Role role) {
        return null;
    }
}
