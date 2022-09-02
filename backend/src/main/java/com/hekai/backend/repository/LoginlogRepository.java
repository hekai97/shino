package com.hekai.backend.repository;

import com.hekai.backend.entity.Loginlog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginlogRepository extends JpaRepository<Loginlog, Integer> {
}