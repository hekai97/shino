package com.hekai.backend.dto;

import com.hekai.backend.entity.CourseReservation;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link com.hekai.backend.entity.OrderGoods} entity
 */
@Data
public class OrderGoodsDto implements Serializable {
    private int id;
    private Integer courseId;
    private Integer orderDetailId;
    private String writeOffCodeNumber;
    private Integer reserveId;
    private Integer courseTableId;

    //从订单详情中拿到orderId
    private Integer orderId;
    //从订单项表中拿到orderNumber
    private String orderNumber;
    //从订单详情中拿到这个价格
    private BigDecimal price;

    //从订单详情中拿到这个分类
    private String categoryName;
    //从课程表中拿到课程名
    private String courseName;
    //从课程表中拿到课程图片
    private String pictureUrl;

    //课程预约情况，如果没有预约的话这项为空，而且，如果reserveId为空的话这项也为空
    private CourseReservation courseReservation;
    //课程排课情况，如果管理端没有排课的话这项为空，而且，如果courseTableId为空的话这项也为空
    private CourseTableDto courseTable;
}