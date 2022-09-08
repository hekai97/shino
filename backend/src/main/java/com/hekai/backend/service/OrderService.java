package com.hekai.backend.service;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.OrderDetailDto;
import com.hekai.backend.dto.OrderItemDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 订单服务
 *
 * @author 17316
 * @date 2022/09/06
 */
public interface OrderService {
    /**
     * 得到订单列表可分页
     *
     * @param pageable 可分页
     * @return {@link ServerResponse}<{@link Page}<{@link OrderItemDto}>>
     */
    ServerResponse<Page<OrderItemDto>> getOrderListPageable(Pageable pageable);

    /**
     * 被订单号订单细节
     *
     * @param orderNumber 订单号
     * @return {@link ServerResponse}<{@link List}<{@link OrderDetailDto}>>
     */
    ServerResponse<List<OrderDetailDto>> getOrderDetailByOrderNumber(String orderNumber);

    /**
     * 得到用户订单列表
     *
     * @param id id
     * @return {@link ServerResponse}<{@link List}<{@link OrderItemDto}>>
     */
    ServerResponse<List<OrderItemDto>> getUserOrderList(Integer id);

    /**
     * 让用户通过订单号订单详细信息
     *
     * @param orderNumber 订单号
     * @return {@link ServerResponse}<{@link List}<{@link OrderDetailDto}>>
     */
    ServerResponse<List<OrderDetailDto>> getUserOrderDetailByOrderNumber(String orderNumber);

    /**
     * 创建订单
     *
     * @param userId 用户id
     * @param id     id
     * @param type   类型
     * @return {@link ServerResponse}<{@link OrderItemDto}>
     */
    ServerResponse<OrderItemDto> createOrder(Integer userId, Integer id, Integer type);

    /**
     * 取消订单
     *
     * @param userId  用户id
     * @param orderNo 订单没有
     * @return {@link ServerResponse}<{@link OrderItemDto}>
     */
    ServerResponse<OrderItemDto> cancelOrder(int userId, String orderNo);
}