package com.hekai.backend.repository;

import com.hekai.backend.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    OrderItem findOrderItemByOrderNumber(String orderNumber);

    List<OrderItem> findOrderItemsByUserId(Integer id);
}