package com.hekai.backend.repository;

import com.hekai.backend.entity.CmsCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CmsCategoryRepository extends JpaRepository<CmsCategory, Integer> {
}