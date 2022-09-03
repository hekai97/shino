package com.hekai.backend.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "course_reservation", schema = "my_shinho", catalog = "")
public class CourseReservation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "course_id")
    private Integer courseId;
    @Basic
    @Column(name = "store_id")
    private Integer storeId;
    @Basic
    @Column(name = "date")
    private Timestamp date;
    @Basic
    @Column(name = "begin_time")
    private Timestamp beginTime;
    @Basic
    @Column(name = "end_time")
    private Timestamp endTime;
    @Basic
    @Column(name = "arrangement_date")
    private Date arrangementDate;
    @Basic
    @Column(name = "order_begin_time")
    private Time orderBeginTime;
    @Basic
    @Column(name = "order_end_time")
    private Time orderEndTime;
    @Basic
    @Column(name = "order_id")
    private Integer orderId;
    @Basic
    @Column(name = "operate_time")
    private Timestamp operateTime;
    @Basic
    @Column(name = "display")
    private Integer display;
    @Basic
    @Column(name = "start_time")
    private Date startTime;
    @Basic
    @Column(name = "state")
    private Integer state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Timestamp getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Timestamp beginTime) {
        this.beginTime = beginTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Date getArrangementDate() {
        return arrangementDate;
    }

    public void setArrangementDate(Date arrangementDate) {
        this.arrangementDate = arrangementDate;
    }

    public Time getOrderBeginTime() {
        return orderBeginTime;
    }

    public void setOrderBeginTime(Time orderBeginTime) {
        this.orderBeginTime = orderBeginTime;
    }

    public Time getOrderEndTime() {
        return orderEndTime;
    }

    public void setOrderEndTime(Time orderEndTime) {
        this.orderEndTime = orderEndTime;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Timestamp getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Timestamp operateTime) {
        this.operateTime = operateTime;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
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
        CourseReservation that = (CourseReservation) o;
        return id == that.id && Objects.equals(courseId, that.courseId) && Objects.equals(storeId, that.storeId) && Objects.equals(date, that.date) && Objects.equals(beginTime, that.beginTime) && Objects.equals(endTime, that.endTime) && Objects.equals(arrangementDate, that.arrangementDate) && Objects.equals(orderBeginTime, that.orderBeginTime) && Objects.equals(orderEndTime, that.orderEndTime) && Objects.equals(orderId, that.orderId) && Objects.equals(operateTime, that.operateTime) && Objects.equals(display, that.display) && Objects.equals(startTime, that.startTime) && Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseId, storeId, date, beginTime, endTime, arrangementDate, orderBeginTime, orderEndTime, orderId, operateTime, display, startTime, state);
    }
}
