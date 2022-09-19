package com.hekai.backend.repository;

import com.hekai.backend.entity.OrderGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderGoodsRepository extends JpaRepository<OrderGoods, Integer> {
    List<OrderGoods> findOrderGoodsByOrderDetailIdInAndReserveIdIsNull(List<Integer> orderDetailIdList);

    List<OrderGoods> findOrderGoodsByOrderDetailIdInAndReserveIdIsNotNull(List<Integer> orderDetailIdList);

    OrderGoods findOrderGoodsByOrderDetailIdAndReserveIdIsNull(Integer orderDetailId);
}