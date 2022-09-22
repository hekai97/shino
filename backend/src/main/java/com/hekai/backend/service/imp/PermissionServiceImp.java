package com.hekai.backend.service.imp;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.entity.EmployeeUser;
import com.hekai.backend.entity.PermissionList;
import com.hekai.backend.entity.RelationRolePermission;
import com.hekai.backend.entity.Role;
import com.hekai.backend.repository.EmployeeUserRepository;
import com.hekai.backend.repository.PermissionListRepository;
import com.hekai.backend.repository.RelationRolePermissionRepository;
import com.hekai.backend.repository.RoleRepository;
import com.hekai.backend.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PermissionServiceImp implements PermissionService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PermissionListRepository permissionListRepository;
    @Autowired
    private RelationRolePermissionRepository relationRolePermissionRepository;
    @Autowired
    private EmployeeUserRepository employeeUserRepository;

    @Override
    public ServerResponse<Page<Role>> getRoleListPageable(Pageable pageable) {
        Page<Role> result=roleRepository.findAll(pageable);
        return ServerResponse.createRespBySuccess(result);
    }

    @Override
    public ServerResponse<List<PermissionList>> getPermissionsOfRole(Integer roleId) {
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
    public ServerResponse<Role> addRole(EmployeeUser operator, Role role) {
        role.setCreatedTime(new Timestamp(new Date().getTime()));
        role.setCreator(operator.getName());
        role.setIsSystemCreatedAccount(operator.getRoleId());
        return ServerResponse.createRespBySuccess(roleRepository.save(role));
    }

    @Override
    public ServerResponse<Role> deleteRole(Role role) {
        List<RelationRolePermission> relationRolePermissions=relationRolePermissionRepository.findRelationRolePermissionsByRoleId(role.getId());
        if(relationRolePermissions.size()!=0){
            return ServerResponse.createByErrorMessage("该角色下存在权限，无法删除");
        }
        List<EmployeeUser> employeeUsers=employeeUserRepository.findEmployeeUsersByRoleId(role.getId());
        if(employeeUsers.size()!=0){
            return ServerResponse.createByErrorMessage("该角色下存在用户，无法删除");
        }
        roleRepository.delete(role);
        return ServerResponse.createRespBySuccessMessage("删除成功");
    }

    @Override
    public ServerResponse<List<PermissionList>> getPermissionNotInRole(Integer roleId) {
        List<PermissionList> permissionLists=permissionListRepository.findAll();
        List<RelationRolePermission> relationRolePermissions=relationRolePermissionRepository.findRelationRolePermissionsByRoleId(roleId);
        List<PermissionList> result=new ArrayList<>();
        for(PermissionList p:permissionLists){
            boolean flag=true;
            for(RelationRolePermission r:relationRolePermissions){
                if(p.getId()==r.getPermissionId()){
                    flag=false;
                    break;
                }
            }
            if(flag){
                result.add(p);
            }
        }
        return ServerResponse.createRespBySuccess(result);
    }
}
