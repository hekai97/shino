package com.hekai.backend.dto;

import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单细节dto
 * 这个类由，cur_course_details（主要），ord_order_goods，cur_course这三张表构成
 *
 * @author 17316
 * @date 2022/09/03
 */
@Data
public class OrderDetailDto implements Serializable {
    private int id;
    private Integer orderId;
    private Integer courseId;
    //由Id查出对应的课程名，在cur_course表中查询
    private String courseName;
    private Integer courseTypeId;
    //该属性在cur_course_details表中，0代表单节课，1代表套餐
    private String courseType;
    //课程的分类，对应的是cur_course表中的course_category_id所对应的类别
    //根据courseId在cur_course_category表中查出
    private String categoryName;
    private BigDecimal price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(Integer courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
