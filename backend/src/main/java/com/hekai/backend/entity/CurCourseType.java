package com.hekai.backend.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "cur_course_type", schema = "shinho", catalog = "")
public class CurCourseType {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "classifyname")
    private String classifyname;
    @Basic
    @Column(name = "iconurl")
    private String iconurl;
    @Basic
    @Column(name = "ispublished")
    private Integer ispublished;
    @Basic
    @Column(name = "createId")
    private Integer createId;
    @Basic
    @Column(name = "courteDate")
    private Date courteDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassifyname() {
        return classifyname;
    }

    public void setClassifyname(String classifyname) {
        this.classifyname = classifyname;
    }

    public String getIconurl() {
        return iconurl;
    }

    public void setIconurl(String iconurl) {
        this.iconurl = iconurl;
    }

    public Integer getIspublished() {
        return ispublished;
    }

    public void setIspublished(Integer ispublished) {
        this.ispublished = ispublished;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getCourteDate() {
        return courteDate;
    }

    public void setCourteDate(Date courteDate) {
        this.courteDate = courteDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurCourseType that = (CurCourseType) o;
        return id == that.id && Objects.equals(classifyname, that.classifyname) && Objects.equals(iconurl, that.iconurl) && Objects.equals(ispublished, that.ispublished) && Objects.equals(createId, that.createId) && Objects.equals(courteDate, that.courteDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, classifyname, iconurl, ispublished, createId, courteDate);
    }
}
