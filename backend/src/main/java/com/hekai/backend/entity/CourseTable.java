package com.hekai.backend.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "course_table", schema = "my_shinho", catalog = "")
public class CourseTable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "store_id")
    private Integer storeId;
    @Basic
    @Column(name = "course_id")
    private Integer courseId;
    @Basic
    @Column(name = "teacher_id")
    private Integer teacherId;
    @Basic
    @Column(name = "user_id")
    private Integer userId;
    @Basic
    @Column(name = "create_time")
    private Timestamp createTime;
    @Basic
    @Column(name = "reservation_date")
    private Date reservationDate;
    @Basic
    @Column(name = "begin_time")
    private Time beginTime;
    @Basic
    @Column(name = "end_time")
    private Time endTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Time getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Time beginTime) {
        this.beginTime = beginTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseTable that = (CourseTable) o;
        return id == that.id && Objects.equals(storeId, that.storeId) && Objects.equals(courseId, that.courseId) && Objects.equals(teacherId, that.teacherId) && Objects.equals(userId, that.userId) && Objects.equals(createTime, that.createTime) && Objects.equals(reservationDate, that.reservationDate) && Objects.equals(beginTime, that.beginTime) && Objects.equals(endTime, that.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, storeId, courseId, teacherId, userId, createTime, reservationDate, beginTime, endTime);
    }
}
