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
    @Column(name = "coursetypeid")
    private Integer coursetypeid;
    @Basic
    @Column(name = "courseprice")
    private BigDecimal courseprice;
    @Basic
    @Column(name = "coursepoints")
    private Integer coursepoints;
    @Basic
    @Column(name = "slideposition")
    private Integer slideposition;
    @Basic
    @Column(name = "ispublished")
    private Integer ispublished;
    @Basic
    @Column(name = "creater")
    private String creater;
    @Basic
    @Column(name = "createtime")
    private Timestamp createtime;
    @Basic
    @Column(name = "updater")
    private String updater;
    @Basic
    @Column(name = "updatetime")
    private Timestamp updatetime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCoursetypeid() {
        return coursetypeid;
    }

    public void setCoursetypeid(Integer coursetypeid) {
        this.coursetypeid = coursetypeid;
    }

    public BigDecimal getCourseprice() {
        return courseprice;
    }

    public void setCourseprice(BigDecimal courseprice) {
        this.courseprice = courseprice;
    }

    public Integer getCoursepoints() {
        return coursepoints;
    }

    public void setCoursepoints(Integer coursepoints) {
        this.coursepoints = coursepoints;
    }

    public Integer getSlideposition() {
        return slideposition;
    }

    public void setSlideposition(Integer slideposition) {
        this.slideposition = slideposition;
    }

    public Integer getIspublished() {
        return ispublished;
    }

    public void setIspublished(Integer ispublished) {
        this.ispublished = ispublished;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurCourseConfig that = (CurCourseConfig) o;
        return id == that.id && Objects.equals(coursetypeid, that.coursetypeid) && Objects.equals(courseprice, that.courseprice) && Objects.equals(coursepoints, that.coursepoints) && Objects.equals(slideposition, that.slideposition) && Objects.equals(ispublished, that.ispublished) && Objects.equals(creater, that.creater) && Objects.equals(createtime, that.createtime) && Objects.equals(updater, that.updater) && Objects.equals(updatetime, that.updatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, coursetypeid, courseprice, coursepoints, slideposition, ispublished, creater, createtime, updater, updatetime);
    }
}
