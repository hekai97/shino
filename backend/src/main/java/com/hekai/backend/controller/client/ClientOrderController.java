package com.hekai.backend.controller.client;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.OrderDetailDto;
import com.hekai.backend.dto.OrderItemDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class ClientOrderController {

    @RequestMapping(value = "/getUserOrderList",method = RequestMethod.POST)
    public ServerResponse<List<OrderItemDto>> getUserOrderList(HttpSession httpSession){
        return null;
    }

    @RequestMapping(value = "/getUserOrderDetailByOrderNumber",method = RequestMethod.POST)
    public ServerResponse<List<OrderDetailDto>> getUserOrderDetailByOrderNumber(HttpSession httpSession,String orderNumber){
        return null;
    }

    /**
     * 创建订单
     *
     * @param httpSession http会话
     * @param id          id 根据类型选择course_id或者是package_id
     * @param type        类型 类型可以是Package或者Single
     * @return {@link ServerResponse}<{@link List}<{@link OrderItemDto}>>
     */
    @RequestMapping(value = "/createOrder",method = RequestMethod.POST)
    public ServerResponse<List<OrderItemDto>> createOrder(HttpSession httpSession, Integer id,String type){
        return null;
    }

    @RequestMapping(value = "/cancelOrder",method = RequestMethod.POST)
    public ServerResponse<OrderItemDto> cancelOrder(HttpSession httpSession,String orderNo){
        return null;
    }
}
