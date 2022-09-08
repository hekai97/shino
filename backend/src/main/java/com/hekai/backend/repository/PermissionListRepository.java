package com.hekai.backend.repository;

import com.hekai.backend.entity.PermissionList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionListRepository extends JpaRepository<PermissionList, Integer> {
    PermissionList findPermissionListById(Integer id);
}