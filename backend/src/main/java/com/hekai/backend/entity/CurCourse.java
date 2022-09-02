package com.hekai.backend.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "cur_course", schema = "shinho", catalog = "")
public class CurCourse {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "coursetypeid")
    private Integer coursetypeid;
    @Basic
    @Column(name = "coursename")
    private String coursename;
    @Basic
    @Column(name = "coursenum")
    private String coursenum;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "courseurl")
    private String courseurl;
    @Basic
    @Column(name = "picurl")
    private String picurl;
    @Basic
    @Column(name = "coursecontent")
    private String coursecontent;
    @Basic
    @Column(name = "courselevel")
    private String courselevel;
    @Basic
    @Column(name = "ispublic")
    private Integer ispublic;
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
    @Basic
    @Column(name = "carouselimg")
    private String carouselimg;

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

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCoursenum() {
        return coursenum;
    }

    public void setCoursenum(String coursenum) {
        this.coursenum = coursenum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourseurl() {
        return courseurl;
    }

    public void setCourseurl(String courseurl) {
        this.courseurl = courseurl;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getCoursecontent() {
        return coursecontent;
    }

    public void setCoursecontent(String coursecontent) {
        this.coursecontent = coursecontent;
    }

    public String getCourselevel() {
        return courselevel;
    }

    public void setCourselevel(String courselevel) {
        this.courselevel = courselevel;
    }

    public Integer getIspublic() {
        return ispublic;
    }

    public void setIspublic(Integer ispublic) {
        this.ispublic = ispublic;
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

    public String getCarouselimg() {
        return carouselimg;
    }

    public void setCarouselimg(String carouselimg) {
        this.carouselimg = carouselimg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurCourse curCourse = (CurCourse) o;
        return id == curCourse.id && Objects.equals(coursetypeid, curCourse.coursetypeid) && Objects.equals(coursename, curCourse.coursename) && Objects.equals(coursenum, curCourse.coursenum) && Objects.equals(description, curCourse.description) && Objects.equals(courseurl, curCourse.courseurl) && Objects.equals(picurl, curCourse.picurl) && Objects.equals(coursecontent, curCourse.coursecontent) && Objects.equals(courselevel, curCourse.courselevel) && Objects.equals(ispublic, curCourse.ispublic) && Objects.equals(creater, curCourse.creater) && Objects.equals(createtime, curCourse.createtime) && Objects.equals(updater, curCourse.updater) && Objects.equals(updatetime, curCourse.updatetime) && Objects.equals(carouselimg, curCourse.carouselimg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, coursetypeid, coursename, coursenum, description, courseurl, picurl, coursecontent, courselevel, ispublic, creater, createtime, updater, updatetime, carouselimg);
    }
}
