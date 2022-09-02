package com.hekai.backend.repository;

import com.hekai.backend.entity.BasicUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasicUserRepository extends JpaRepository<BasicUser, Integer> {
}