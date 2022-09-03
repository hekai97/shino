package com.hekai.backend.controller.backstage;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.OrderDetailDto;
import com.hekai.backend.dto.OrderItemDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/admin/order")
public class AdminOrderController {
    @RequestMapping(value = "/getOrderListPageable",method = RequestMethod.POST)
    public ServerResponse<List<OrderItemDto>> getOrderListPageable(HttpSession httpSession,Integer pageSize,Integer pageNumber){
        return null;
    }
    @RequestMapping(value = "/getOrderDetailByOrderNumber",method = RequestMethod.POST)
    public ServerResponse<OrderDetailDto> getOrderDetailByOrderNumber(HttpSession httpSession,String orderNumber){
        return null;
    }
}
