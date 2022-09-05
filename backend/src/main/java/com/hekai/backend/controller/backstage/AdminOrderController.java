package com.hekai.backend.controller.backstage;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.OrderDetailDto;
import com.hekai.backend.dto.OrderItemDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/admin/order")
public class AdminOrderController {
    @RequestMapping(value = "/getOrderListPageable",method = RequestMethod.POST)
    public ServerResponse<Page<OrderItemDto>> getOrderListPageable(HttpSession httpSession, Pageable pageable){
        return null;
    }
    @RequestMapping(value = "/getOrderDetailByOrderNumber",method = RequestMethod.POST)
    public ServerResponse<OrderDetailDto> getOrderDetailByOrderNumber(HttpSession httpSession,String orderNumber){
        return null;
    }
}
