package com.hekai.backend.controller.backstage;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.OrderDetailDto;
import com.hekai.backend.dto.OrderItemDto;
import com.hekai.backend.dto.TimeAndCountDto;
import com.hekai.backend.entity.EmployeeUser;
import com.hekai.backend.service.OrderService;
import com.hekai.backend.utils.ConstUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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
    @Operation(summary = "通过订单号获取订单详情")
    @RequestMapping(value = "/getOrderDetailByOrderNumber",method = RequestMethod.POST)
    public ServerResponse<List<OrderDetailDto>> getOrderDetailByOrderNumber(HttpSession httpSession, @Parameter String orderNumber){
        EmployeeUser curUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(curUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return orderService.getOrderDetailByOrderNumber(orderNumber);
    }

    /**
     * 被存储订单项id
     *
     * @param httpSession http会话
     * @param pageable    可分页
     * @param storeId     存储id
     * @return {@link ServerResponse}<{@link Page}<{@link OrderItemDto}>>
     */
    @Operation(summary = "根据商店Id获取每个商店的所有订单")
    @RequestMapping(value = "/getOrderItemsByStoreIdPageable",method = RequestMethod.POST)
    public ServerResponse<Page<OrderItemDto>> getOrderItemsByStoreId(HttpSession httpSession,@ParameterObject Pageable pageable, @Parameter Integer storeId){
        EmployeeUser curUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(curUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return orderService.getOrderItemsByStoreId(pageable,storeId);
    }

    /**
     * 被存储id受益
     *
     * @param httpSession http会话
     * @param storeId     存储id
     * @return {@link ServerResponse}<{@link BigDecimal}>
     */
    @Operation(summary = "根据storeId获取每个店铺的收益")
    @RequestMapping(value = "/getBenefitByStoreId",method = RequestMethod.POST)
    public ServerResponse<BigDecimal> getBenefitByStoreId(HttpSession httpSession, @Parameter Integer storeId){
        EmployeeUser curUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(curUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return orderService.getBenefitByStoreId(storeId);
    }

    /**
     * 得到所有付费用户数量
     *
     * @param httpSession http会话
     * @return {@link ServerResponse}<{@link Integer}>
     */
    @Operation(summary = "获取所有付款的用户数量，已去重")
    @RequestMapping(value = "/getAllPaidUserNumber",method = RequestMethod.GET)
    public ServerResponse<Integer> getAllPaidUserNumber(HttpSession httpSession){
        EmployeeUser curUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(curUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return orderService.getAllPaidUserNumber();
    }

    /**
     * 得到订单项日期
     *
     * @param httpSession http会话
     * @param day         一天
     * @return {@link ServerResponse}<{@link Map}<{@link String},{@link Integer}>>
     */
    @Operation(summary = "按照时间获取过去七天每天的订单数量")
    @RequestMapping(value = "/getOrderItemsByDate",method = RequestMethod.GET)
    public ServerResponse<List<TimeAndCountDto>> getOrderItemsByDate(HttpSession httpSession, @Parameter(description = "可为空，默认为7") @Nullable Integer day){
        EmployeeUser curUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(curUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        if(day==null){
            day=7;
        }
        return orderService.getOrderItemsByDate(day);
    }
}
