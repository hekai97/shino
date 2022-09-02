package com.hekai.backend.repository;

import com.hekai.backend.entity.BasicStore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasicStoreRepository extends JpaRepository<BasicStore, Integer> {
}