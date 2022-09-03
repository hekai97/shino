package com.hekai.backend.repository;

import com.hekai.backend.entity.OrderGoods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderGoodsRepository extends JpaRepository<OrderGoods, Integer> {
}