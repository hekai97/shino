package com.hekai.backend.repository;

import com.hekai.backend.entity.Suggested;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuggestedRepository extends JpaRepository<Suggested, Integer> {
}