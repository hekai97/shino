package com.hekai.backend.repository;

import com.hekai.backend.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Integer> {
    Store findStoreById(Integer id);
}