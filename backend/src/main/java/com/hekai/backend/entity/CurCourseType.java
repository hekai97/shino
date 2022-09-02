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
    @Column(name = "classify_name")
    private String classifyName;
    @Basic
    @Column(name = "icon_url")
    private String iconUrl;
    @Basic
    @Column(name = "is_published")
    private Integer isPublished;
    @Basic
    @Column(name = "created_Id")
    private Integer createdId;
    @Basic
    @Column(name = "create_time")
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public Integer getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(Integer isPublished) {
        this.isPublished = isPublished;
    }

    public Integer getCreatedId() {
        return createdId;
    }

    public void setCreatedId(Integer createdId) {
        this.createdId = createdId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurCourseType that = (CurCourseType) o;
        return id == that.id && Objects.equals(classifyName, that.classifyName) && Objects.equals(iconUrl, that.iconUrl) && Objects.equals(isPublished, that.isPublished) && Objects.equals(createdId, that.createdId) && Objects.equals(createTime, that.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, classifyName, iconUrl, isPublished, createdId, createTime);
    }
}
