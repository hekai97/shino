package com.hekai.backend.controller.client;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.OrderDetailDto;
import com.hekai.backend.dto.OrderGoodsDto;
import com.hekai.backend.dto.OrderItemDto;
import com.hekai.backend.entity.CourseReservation;
import com.hekai.backend.entity.User;
import com.hekai.backend.service.OrderService;
import com.hekai.backend.utils.ConstUtil;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "获取用户未付款的订单，相当于购物车中的订单")
    @RequestMapping(value = "/getUserUnPaidOrderList",method = RequestMethod.POST)
    public ServerResponse<List<OrderItemDto>> getUserOrderList(HttpSession httpSession){
        User user=(User) httpSession.getAttribute(ConstUtil.NORMAL_USER);
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登录！");
        }
        return orderService.getUserUnPaidOrderList(user.getId());
    }
    @Operation(summary = "通过orderItemId获取用户的订单的详情")
    @RequestMapping(value = "/getUserOrderDetailByOrderItemId",method = RequestMethod.POST)
    public ServerResponse<List<OrderDetailDto>> getUserOrderDetailByOrderItemId(HttpSession httpSession,
                                                                         @Parameter(description = "订单项id") Integer orderItemId){
        User user=(User) httpSession.getAttribute(ConstUtil.NORMAL_USER);
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登录！");
        }
        return orderService.getUserOrderDetailByOrderItemId(user.getId(),orderItemId);
    }


    @Operation(summary = "获取用户已经付款的订单，包括已经付款的订单和交易关闭（完成）的订单")
    @RequestMapping(value = "/getUserPaidOrderList",method = RequestMethod.POST)
    public ServerResponse<List<OrderItemDto>> getUserPaidOrderList(HttpSession httpSession){
        User user=(User) httpSession.getAttribute(ConstUtil.NORMAL_USER);
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登录！");
        }
        return orderService.getUserPaidOrderList(user.getId());
    }
    @Operation(summary = "获取售后中的订单")
    @RequestMapping(value = "/getAfterSaleOrderList",method = RequestMethod.POST)
    public ServerResponse<List<OrderItemDto>> getAfterSaleOrderList(HttpSession httpSession){
        User user=(User) httpSession.getAttribute(ConstUtil.NORMAL_USER);
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登录！");
        }
        return orderService.getAfterSaleOrderList(user.getId());
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

    @Operation(summary = "获取用户没有预约的订单")
    @RequestMapping(value = "/getNoReservationsOrderGoods",method = RequestMethod.GET)
    public ServerResponse<List<OrderGoodsDto>> getNoReservations(HttpSession httpSession){
        User user = (User) httpSession.getAttribute(ConstUtil.NORMAL_USER);
        if (user == null){
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        return orderService.getNoReservations(user.getId());
    }
    @Operation(summary = "获取用户已经预约的订单")
    @RequestMapping(value = "/getReservationsOrderGoods",method = RequestMethod.GET)
    public ServerResponse<List<OrderGoodsDto>> getReservations(HttpSession httpSession){
        User user = (User) httpSession.getAttribute(ConstUtil.NORMAL_USER);
        if (user == null){
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        return orderService.getReservations(user.getId());
    }
    @Operation(summary = "用户预约课程")
    @RequestMapping(value = "/userCreateReservations",method = RequestMethod.POST)
    public ServerResponse<String> userCreateReservations(HttpSession httpSession,
                                                         @Parameter(description = "订单详情Id") Integer orderDetailId,
                                                         @Parameter(description = "店铺id") Integer storeId,
                                                         @Parameter(description = "预约日期") String time,
                                                         @Parameter(description = "预约时间段,参数1代表第一节课，就是第一节课的开始时间和结束时间，其他同理，最高为4") Integer group){
        User user = (User) httpSession.getAttribute(ConstUtil.NORMAL_USER);
        if (user == null){
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        return orderService.userCreateReservations(user.getId(),orderDetailId,storeId,time,group);
    }
    @Operation(summary = "通过预约的Id查看预约详情")
    @RequestMapping(value = "/getReservationsDetailByReservationId",method = RequestMethod.GET)
    public ServerResponse<CourseReservation> getReservationsDetailByReservationId(HttpSession httpSession,
                                                                                  @Parameter(description = "预约Id") Integer courseReservationId){
        User user = (User) httpSession.getAttribute(ConstUtil.NORMAL_USER);
        if (user == null){
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        return orderService.getReservationsDetailByReservationId(courseReservationId);
    }
}
