package com.hekai.backend.repository;

import com.hekai.backend.entity.OrderItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    OrderItem findOrderItemByOrderNumber(String orderNumber);

    List<OrderItem> findOrderItemsByUserId(Integer id);

    OrderItem findOrderItemById(Integer id);

    Page<OrderItem> findOrderItemsByIdIn(List<Integer> orderIdList, Pageable pageable);
    Page<OrderItem> findOrderItemsByIdInAndStatusIsNot(List<Integer> orderIdList, Integer status, Pageable pageable);

    List<OrderItem> findAllByIdInAndStatusIsNot(List<Integer> orderIdList, Integer unpaid);

    @Query(value = "select count(distinct user_id) from order_item", nativeQuery = true)
    Integer findAllPaidUserByStatusIsNot(Integer status);
    @Query(value = "select count(*) from order_item where status=?1 and pay_time between ?2 and ?3", nativeQuery = true)
    Integer findPaidOrderByStatusIsNotAndPayTimeBetween(Integer unpaid, String start, String end);
}