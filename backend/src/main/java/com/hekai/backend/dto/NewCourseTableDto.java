package com.hekai.backend.dto;


//这是用来创建排课表的时候单独的一个类
public class NewCourseTableDto {
    private Integer courseReservationId;
    private Integer storeId;
    private Integer courseId;
    private Integer teacherId;
    private Integer userId;
    private String date;
    private String beginTime;
    private String endTime;

    public Integer getCourseReservationId() {
        return courseReservationId;
    }

    public void setCourseReservationId(Integer courseReservationId) {
        this.courseReservationId = courseReservationId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    @Override
    public String toString() {
        return "NewCourseTableDto{" +
                "courseReservationId=" + courseReservationId +
                ", storeId=" + storeId +
                ", courseId=" + courseId +
                ", teacherId=" + teacherId +
                ", userId=" + userId +
                ", date='" + date + '\'' +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
