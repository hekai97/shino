package com.hekai.backend.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

@Data
public class CourseReservationDto implements Serializable {
    private int id;
    private Integer courseId;
    //课程名称
    private String courseName;
    private Integer storeId;
    //门店名称
    private String storeName;
    private String date;
    private String beginTime;
    private String endTime;
    private Date arrangementDate;
    private Time orderBeginTime;
    private Time orderEndTime;
    private Integer orderId;
    private String operateTime;
    private Integer display;
    private Date startTime;
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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
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

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
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

}
