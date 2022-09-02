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
    @Column(name = "course_id")
    private Integer courseId;
    @Basic
    @Column(name = "img_url")
    private String imgUrl;

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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurCourseImg that = (CurCourseImg) o;
        return id == that.id && Objects.equals(courseId, that.courseId) && Objects.equals(imgUrl, that.imgUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseId, imgUrl);
    }
}
