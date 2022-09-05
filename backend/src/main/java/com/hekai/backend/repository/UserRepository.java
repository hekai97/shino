package com.hekai.backend.repository;

import com.hekai.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByPhoneNumber(String phoneNumber);
    User findUserByEmail(String Email);
    User findUserById(Integer id);
}