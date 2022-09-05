package com.hekai.backend.controller.backstage;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.OrderDetailDto;
import com.hekai.backend.dto.OrderItemDto;
import com.hekai.backend.entity.EmployeeUser;
import com.hekai.backend.service.OrderService;
import com.hekai.backend.utils.ConstUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/admin/order")
public class AdminOrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping(value = "/getOrderListPageable",method = RequestMethod.POST)
    public ServerResponse<Page<OrderItemDto>> getOrderListPageable(HttpSession httpSession, Pageable pageable){
        EmployeeUser curUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(curUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return orderService.getOrderListPageable(pageable);
    }
    @RequestMapping(value = "/getOrderDetailByOrderNumber",method = RequestMethod.POST)
    public ServerResponse<List<OrderDetailDto>> getOrderDetailByOrderNumber(HttpSession httpSession, String orderNumber){
        EmployeeUser curUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(curUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return orderService.getOrderDetailByOrderNumber(orderNumber);
    }
}
