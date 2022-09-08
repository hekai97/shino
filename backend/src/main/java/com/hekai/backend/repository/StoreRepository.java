package com.hekai.backend.repository;

import com.hekai.backend.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {
    Store findStoreById(Integer id);

    Store findStoreByStoreNumber(String storeNumber);
}