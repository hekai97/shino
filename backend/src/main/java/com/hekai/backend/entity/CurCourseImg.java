package com.hekai.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cur_course_img", schema = "shinho", catalog = "")
public class CurCourseImg {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "courseid")
    private Integer courseid;
    @Basic
    @Column(name = "imgurl")
    private String imgurl;

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

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurCourseImg that = (CurCourseImg) o;
        return id == that.id && Objects.equals(courseid, that.courseid) && Objects.equals(imgurl, that.imgurl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseid, imgurl);
    }
}
