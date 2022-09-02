package com.hekai.backend.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "ord_order_info", schema = "shinho", catalog = "")
public class OrdOrderInfo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "order_number")
    private String orderNumber;
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
    @Column(name = "payment_order_number")
    private String paymentOrderNumber;
    @Basic
    @Column(name = "total_amount")
    private BigDecimal totalAmount;
    @Basic
    @Column(name = "pay_amount")
    private BigDecimal payAmount;
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

    public String getPaymentOrderNumber() {
        return paymentOrderNumber;
    }

    public void setPaymentOrderNumber(String paymentOrderNumber) {
        this.paymentOrderNumber = paymentOrderNumber;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
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
        OrdOrderInfo that = (OrdOrderInfo) o;
        return id == that.id && Objects.equals(orderNumber, that.orderNumber) && Objects.equals(payTime, that.payTime) && Objects.equals(status, that.status) && Objects.equals(paymentWay, that.paymentWay) && Objects.equals(paymentOrderNumber, that.paymentOrderNumber) && Objects.equals(totalAmount, that.totalAmount) && Objects.equals(payAmount, that.payAmount) && Objects.equals(userId, that.userId) && Objects.equals(userLevel, that.userLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderNumber, payTime, status, paymentWay, paymentOrderNumber, totalAmount, payAmount, userId, userLevel);
    }
}
