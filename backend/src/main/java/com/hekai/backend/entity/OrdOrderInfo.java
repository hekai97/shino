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
    @Column(name = "ordernum")
    private String ordernum;
    @Basic
    @Column(name = "paytime")
    private Timestamp paytime;
    @Basic
    @Column(name = "status")
    private Integer status;
    @Basic
    @Column(name = "paymentway")
    private String paymentway;
    @Basic
    @Column(name = "paymentordernum")
    private String paymentordernum;
    @Basic
    @Column(name = "totalamount")
    private BigDecimal totalamount;
    @Basic
    @Column(name = "payamount")
    private BigDecimal payamount;
    @Basic
    @Column(name = "userid")
    private Integer userid;
    @Basic
    @Column(name = "userlevel")
    private String userlevel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }

    public Timestamp getPaytime() {
        return paytime;
    }

    public void setPaytime(Timestamp paytime) {
        this.paytime = paytime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPaymentway() {
        return paymentway;
    }

    public void setPaymentway(String paymentway) {
        this.paymentway = paymentway;
    }

    public String getPaymentordernum() {
        return paymentordernum;
    }

    public void setPaymentordernum(String paymentordernum) {
        this.paymentordernum = paymentordernum;
    }

    public BigDecimal getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(BigDecimal totalamount) {
        this.totalamount = totalamount;
    }

    public BigDecimal getPayamount() {
        return payamount;
    }

    public void setPayamount(BigDecimal payamount) {
        this.payamount = payamount;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUserlevel() {
        return userlevel;
    }

    public void setUserlevel(String userlevel) {
        this.userlevel = userlevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdOrderInfo that = (OrdOrderInfo) o;
        return id == that.id && Objects.equals(ordernum, that.ordernum) && Objects.equals(paytime, that.paytime) && Objects.equals(status, that.status) && Objects.equals(paymentway, that.paymentway) && Objects.equals(paymentordernum, that.paymentordernum) && Objects.equals(totalamount, that.totalamount) && Objects.equals(payamount, that.payamount) && Objects.equals(userid, that.userid) && Objects.equals(userlevel, that.userlevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ordernum, paytime, status, paymentway, paymentordernum, totalamount, payamount, userid, userlevel);
    }
}
