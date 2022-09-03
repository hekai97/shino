package com.hekai.backend.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "order_item", schema = "my_shinho", catalog = "")
public class OrderItem {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "order_number")
    private String orderNumber;
    @Basic
    @Column(name = "created_time")
    private Timestamp createdTime;
    @Basic
    @Column(name = "pay_time")
    private Timestamp payTime;
    @Basic
    @Column(name = "status")
    private Integer status;
    @Basic
    @Column(name = "payment_way")
    private String paymentWay;
    @Basic
    @Column(name = "total_amount")
    private BigDecimal totalAmount;
    @Basic
    @Column(name = "user_id")
    private Integer userId;
    @Basic
    @Column(name = "user_level")
    private String userLevel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public Timestamp getPayTime() {
        return payTime;
    }

    public void setPayTime(Timestamp payTime) {
        this.payTime = payTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPaymentWay() {
        return paymentWay;
    }

    public void setPaymentWay(String paymentWay) {
        this.paymentWay = paymentWay;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return id == orderItem.id && Objects.equals(orderNumber, orderItem.orderNumber) && Objects.equals(createdTime, orderItem.createdTime) && Objects.equals(payTime, orderItem.payTime) && Objects.equals(status, orderItem.status) && Objects.equals(paymentWay, orderItem.paymentWay) && Objects.equals(totalAmount, orderItem.totalAmount) && Objects.equals(userId, orderItem.userId) && Objects.equals(userLevel, orderItem.userLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderNumber, createdTime, payTime, status, paymentWay, totalAmount, userId, userLevel);
    }
}
