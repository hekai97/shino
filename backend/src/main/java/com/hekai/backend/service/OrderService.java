package com.hekai.backend.service;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.OrderDetailDto;
import com.hekai.backend.dto.OrderItemDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {
    ServerResponse<Page<OrderItemDto>> getOrderListPageable(Pageable pageable);

    ServerResponse<List<OrderDetailDto>> getOrderDetailByOrderNumber(String orderNumber);
}
