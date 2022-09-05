package com.hekai.backend.repository;

import com.hekai.backend.entity.RelationRolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RelationRolePermissionRepository extends JpaRepository<RelationRolePermission, Integer> {
    List<RelationRolePermission> findRelationRolePermissionsByRoleId(Integer roleId);
    RelationRolePermission findRelationRolePermissionByRoleIdAndPermissionId(Integer roleId,Integer permissionId);
}