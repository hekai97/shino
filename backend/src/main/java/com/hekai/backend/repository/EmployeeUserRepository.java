package com.hekai.backend.repository;

import com.hekai.backend.entity.EmployeeUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeUserRepository extends JpaRepository<EmployeeUser, Integer> {
    EmployeeUser findEmployeeUserById(Integer id);
    EmployeeUser findEmployeeUserByNumber(String number);
}