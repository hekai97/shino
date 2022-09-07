package com.hekai.backend.controller.backstage;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.OrderDetailDto;
import com.hekai.backend.dto.OrderItemDto;
import com.hekai.backend.entity.EmployeeUser;
import com.hekai.backend.service.OrderService;
import com.hekai.backend.utils.ConstUtil;
import io.swagger.v3.oas.annotations.Parameter;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 管理顺序控制器
 *
 * @author 17316
 * @date 2022/09/06
 */
@RestController
@RequestMapping(value = "/admin/order")
public class AdminOrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 得到订单列表可分页
     *
     * @param httpSession http会话
     * @param pageable    可分页
     * @return {@link ServerResponse}<{@link Page}<{@link OrderItemDto}>>
     */
    @RequestMapping(value = "/getOrderListPageable",method = RequestMethod.POST)
    public ServerResponse<Page<OrderItemDto>> getOrderListPageable(HttpSession httpSession, @ParameterObject Pageable pageable){
        EmployeeUser curUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(curUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return orderService.getOrderListPageable(pageable);
    }

    /**
     * 被订单号订单细节
     *
     * @param httpSession http会话
     * @param orderNumber 订单号
     * @return {@link ServerResponse}<{@link List}<{@link OrderDetailDto}>>
     */
    @RequestMapping(value = "/getOrderDetailByOrderNumber",method = RequestMethod.POST)
    public ServerResponse<List<OrderDetailDto>> getOrderDetailByOrderNumber(HttpSession httpSession, @Parameter String orderNumber){
        EmployeeUser curUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(curUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return orderService.getOrderDetailByOrderNumber(orderNumber);
    }
}
