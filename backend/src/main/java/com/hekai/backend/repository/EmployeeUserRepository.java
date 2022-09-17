package com.hekai.backend.repository;

import com.hekai.backend.entity.EmployeeUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeUserRepository extends JpaRepository<EmployeeUser, Integer> {
    EmployeeUser findEmployeeUserById(Integer id);
    EmployeeUser findEmployeeUserByNumber(String number);

    Page<EmployeeUser> findEmployeeUsersByRoleIdNot(Pageable pageable, Integer roleId);
    Page<EmployeeUser> findEmployeeUsersByStoreIdAndRoleIdNot(Pageable pageable, Integer storeId, Integer roleId);

    Page<EmployeeUser> findEmployeeUsersByStoreIdAndRoleIdIn(Pageable pageable, Integer storeId, List<Integer> roleList);

    List<EmployeeUser> findEmployeeUsersByRoleId(Integer storeManager);
}