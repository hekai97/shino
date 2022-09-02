package com.hekai.backend.repository;

import com.hekai.backend.entity.BasicPermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasicPermissionRepository extends JpaRepository<BasicPermission, Integer> {
}