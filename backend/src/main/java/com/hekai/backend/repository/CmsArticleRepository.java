package com.hekai.backend.repository;

import com.hekai.backend.entity.CmsArticle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CmsArticleRepository extends JpaRepository<CmsArticle, Integer> {
}