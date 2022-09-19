package com.hekai.backend.repository;

import com.hekai.backend.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
    List<OrderDetail> findOrderDetailsByOrderId(Integer orderId);

    List<OrderDetail> findOrderDetailsByCourseIdIn(List<Integer> courseIdList);

    List<OrderDetail> findAllByCourseIdIn(List<Integer> courseIdList);

    List<OrderDetail> findOrderDetailsByOrderIdIn(List<Integer> orderIdList);

    OrderDetail findOrderDetailById(Integer orderDetailId);
}