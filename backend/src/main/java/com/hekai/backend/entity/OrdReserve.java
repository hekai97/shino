package com.hekai.backend.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "ord_reserve", schema = "shinho", catalog = "")
public class OrdReserve {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "courseid")
    private Integer courseid;
    @Basic
    @Column(name = "storeid")
    private Integer storeid;
    @Basic
    @Column(name = "date")
    private Timestamp date;
    @Basic
    @Column(name = "begintime")
    private Timestamp begintime;
    @Basic
    @Column(name = "endtime")
    private Timestamp endtime;
    @Basic
    @Column(name = "arrangementdate")
    private Date arrangementdate;
    @Basic
    @Column(name = "orderbegintime")
    private Time orderbegintime;
    @Basic
    @Column(name = "orderendtime")
    private Time orderendtime;
    @Basic
    @Column(name = "orderid")
    private Integer orderid;
    @Basic
    @Column(name = "operatetime")
    private Timestamp operatetime;
    @Basic
    @Column(name = "ordertype")
    private Integer ordertype;
    @Basic
    @Column(name = "display")
    private Integer display;
    @Basic
    @Column(name = "starttime")
    private Date starttime;
    @Basic
    @Column(name = "state")
    private Integer state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public Integer getStoreid() {
        return storeid;
    }

    public void setStoreid(Integer storeid) {
        this.storeid = storeid;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Timestamp getBegintime() {
        return begintime;
    }

    public void setBegintime(Timestamp begintime) {
        this.begintime = begintime;
    }

    public Timestamp getEndtime() {
        return endtime;
    }

    public void setEndtime(Timestamp endtime) {
        this.endtime = endtime;
    }

    public Date getArrangementdate() {
        return arrangementdate;
    }

    public void setArrangementdate(Date arrangementdate) {
        this.arrangementdate = arrangementdate;
    }

    public Time getOrderbegintime() {
        return orderbegintime;
    }

    public void setOrderbegintime(Time orderbegintime) {
        this.orderbegintime = orderbegintime;
    }

    public Time getOrderendtime() {
        return orderendtime;
    }

    public void setOrderendtime(Time orderendtime) {
        this.orderendtime = orderendtime;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Timestamp getOperatetime() {
        return operatetime;
    }

    public void setOperatetime(Timestamp operatetime) {
        this.operatetime = operatetime;
    }

    public Integer getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(Integer ordertype) {
        this.ordertype = ordertype;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdReserve that = (OrdReserve) o;
        return id == that.id && Objects.equals(courseid, that.courseid) && Objects.equals(storeid, that.storeid) && Objects.equals(date, that.date) && Objects.equals(begintime, that.begintime) && Objects.equals(endtime, that.endtime) && Objects.equals(arrangementdate, that.arrangementdate) && Objects.equals(orderbegintime, that.orderbegintime) && Objects.equals(orderendtime, that.orderendtime) && Objects.equals(orderid, that.orderid) && Objects.equals(operatetime, that.operatetime) && Objects.equals(ordertype, that.ordertype) && Objects.equals(display, that.display) && Objects.equals(starttime, that.starttime) && Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseid, storeid, date, begintime, endtime, arrangementdate, orderbegintime, orderendtime, orderid, operatetime, ordertype, display, starttime, state);
    }
}
