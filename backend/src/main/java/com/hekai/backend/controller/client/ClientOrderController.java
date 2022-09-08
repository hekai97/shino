package com.hekai.backend.controller.client;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.OrderDetailDto;
import com.hekai.backend.dto.OrderItemDto;
import com.hekai.backend.entity.User;
import com.hekai.backend.service.OrderService;
import com.hekai.backend.utils.ConstUtil;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 客户订单控制器
 *
 * @author 17316
 * @date 2022/09/06
 */
@RestController
@RequestMapping(value = "/order")
public class ClientOrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 得到用户订单列表
     *
     * @param httpSession http会话
     * @return {@link ServerResponse}<{@link List}<{@link OrderItemDto}>>
     */
    @RequestMapping(value = "/getUserOrderList",method = RequestMethod.POST)
    public ServerResponse<List<OrderItemDto>> getUserOrderList(HttpSession httpSession){
        User user=(User) httpSession.getAttribute(ConstUtil.NORMAL_USER);
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登录！");
        }
        return orderService.getUserOrderList(user.getId());
    }

    /**
     * 让用户通过订单号订单详细信息
     *
     * @param httpSession http会话
     * @param orderNumber 订单号
     * @return {@link ServerResponse}<{@link List}<{@link OrderDetailDto}>>
     */
    @RequestMapping(value = "/getUserOrderDetailByOrderNumber",method = RequestMethod.POST)
    public ServerResponse<List<OrderDetailDto>> getUserOrderDetailByOrderNumber(HttpSession httpSession,@Parameter String orderNumber){
        User user=(User) httpSession.getAttribute(ConstUtil.NORMAL_USER);
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登录！");
        }
        return orderService.getUserOrderDetailByOrderNumber(orderNumber);
    }

    /**
     * 创建订单
     *
     * @param httpSession http会话
     * @param id          id 根据类型选择course_id或者是package_id
     * @param type        类型 类型可以是Package或者Single
     * @return {@link ServerResponse}<{@link OrderItemDto}>
     */
    @RequestMapping(value = "/createOrder",method = RequestMethod.POST)
    public ServerResponse<OrderItemDto> createOrder(HttpSession httpSession,
                                                    @Parameter(description = "0代表单节课，1代表套餐课") Integer type,
                                                    @Parameter(description = "如果type为0，那么这个值就是courseId，否则，这个值就是PackageId") Integer id){
        User user=(User) httpSession.getAttribute(ConstUtil.NORMAL_USER);
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登录！");
        }
        return orderService.createOrder(user.getId(),id,type);
    }

    /**
     * 取消订单
     *
     * @param httpSession http会话
     * @param orderNo     订单没有
     * @return {@link ServerResponse}<{@link OrderItemDto}>
     */
    @RequestMapping(value = "/cancelOrder",method = RequestMethod.POST)
    public ServerResponse<OrderItemDto> cancelOrder(HttpSession httpSession,@Parameter String orderNo){
        User user=(User) httpSession.getAttribute(ConstUtil.NORMAL_USER);
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登录！");
        }
        return orderService.cancelOrder(user.getId(),orderNo);
    }
}
