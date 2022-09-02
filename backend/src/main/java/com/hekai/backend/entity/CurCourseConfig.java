package com.hekai.backend.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "cur_course_config", schema = "shinho", catalog = "")
public class CurCourseConfig {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "course_type_id")
    private Integer courseTypeId;
    @Basic
    @Column(name = "course_price")
    private BigDecimal coursePrice;
    @Basic
    @Column(name = "course_points")
    private Integer coursePoints;
    @Basic
    @Column(name = "slide_position")
    private Integer slidePosition;
    @Basic
    @Column(name = "is_published")
    private Integer isPublished;
    @Basic
    @Column(name = "creater")
    private String creater;
    @Basic
    @Column(name = "create_time")
    private Timestamp createTime;
    @Basic
    @Column(name = "updater")
    private String updater;
    @Basic
    @Column(name = "update_time")
    private Timestamp updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(Integer courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    public BigDecimal getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(BigDecimal coursePrice) {
        this.coursePrice = coursePrice;
    }

    public Integer getCoursePoints() {
        return coursePoints;
    }

    public void setCoursePoints(Integer coursePoints) {
        this.coursePoints = coursePoints;
    }

    public Integer getSlidePosition() {
        return slidePosition;
    }

    public void setSlidePosition(Integer slidePosition) {
        this.slidePosition = slidePosition;
    }

    public Integer getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(Integer isPublished) {
        this.isPublished = isPublished;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurCourseConfig that = (CurCourseConfig) o;
        return id == that.id && Objects.equals(courseTypeId, that.courseTypeId) && Objects.equals(coursePrice, that.coursePrice) && Objects.equals(coursePoints, that.coursePoints) && Objects.equals(slidePosition, that.slidePosition) && Objects.equals(isPublished, that.isPublished) && Objects.equals(creater, that.creater) && Objects.equals(createTime, that.createTime) && Objects.equals(updater, that.updater) && Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseTypeId, coursePrice, coursePoints, slidePosition, isPublished, creater, createTime, updater, updateTime);
    }
}
