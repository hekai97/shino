package com.hekai.backend.service;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.OrderDetailDto;
import com.hekai.backend.dto.OrderGoodsDto;
import com.hekai.backend.dto.OrderItemDto;
import com.hekai.backend.dto.TimeAndCountDto;
import com.hekai.backend.entity.CourseReservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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
    ServerResponse<List<OrderItemDto>> getUserUnPaidOrderList(Integer id);

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

    /**
     * 更新订单状态
     *
     * @param orderNumber 订单号
     * @param status      状态
     */
    void updateOrderStatus(String orderNumber, int status);

    /**
     * 被存储订单项id
     *
     * @param pageable 可分页
     * @param storeId  存储id
     * @return {@link ServerResponse}<{@link Page}<{@link OrderItemDto}>>
     */
    ServerResponse<Page<OrderItemDto>> getOrderItemsByStoreId(Pageable pageable, Integer storeId);

    /**
     * 被存储id受益
     *
     * @param storeId 存储id
     * @return {@link ServerResponse}<{@link BigDecimal}>
     */
    ServerResponse<BigDecimal> getBenefitByStoreId(Integer storeId);

    /**
     * 得到所有付费用户数量
     *
     * @return {@link ServerResponse}<{@link Integer}>
     */
    ServerResponse<Integer> getAllPaidUserNumber();

    /**
     * 得到订单项日期
     *
     * @param day 一天
     * @return {@link ServerResponse}<{@link Map}<{@link String}, {@link Integer}>>
     */
    ServerResponse<List<TimeAndCountDto>> getOrderItemsByDate(int day);

    ServerResponse<List<OrderItemDto>> getUserPaidOrderList(int id);

    ServerResponse<List<OrderItemDto>> getAfterSaleOrderList(int id);

    ServerResponse<List<OrderGoodsDto>> getNoReservations(Integer userId);

    ServerResponse<List<OrderGoodsDto>> getReservations(Integer userId);

    ServerResponse<String> userCreateReservations(Integer userId, Integer orderDetailId, Integer storeId, String time, Integer group);

    ServerResponse<CourseReservation> getReservationsDetailByReservationId(Integer courseReservationId);

    ServerResponse<List<OrderDetailDto>> getUserOrderDetailByOrderItemId(Integer id, Integer orderItemId);

    void generateWriteOffCode(String out_trade_no);

    void setToPaid(String out_trade_no);
}
