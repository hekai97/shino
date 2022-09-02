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
    @Column(name = "course_type_id")
    private Integer courseTypeId;
    @Basic
    @Column(name = "course_name")
    private String courseName;
    @Basic
    @Column(name = "course_number")
    private String courseNumber;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "course_url")
    private String courseUrl;
    @Basic
    @Column(name = "picture_url")
    private String pictureUrl;
    @Basic
    @Column(name = "course_content")
    private String courseContent;
    @Basic
    @Column(name = "course_level")
    private String courseLevel;
    @Basic
    @Column(name = "is_public")
    private Integer isPublic;
    @Basic
    @Column(name = "creater")
    private String creater;
    @Basic
    @Column(name = "created_time")
    private Timestamp createdTime;
    @Basic
    @Column(name = "updater")
    private String updater;
    @Basic
    @Column(name = "updated_time")
    private Timestamp updatedTime;
    @Basic
    @Column(name = "carousel_img")
    private String carouselImg;

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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourseUrl() {
        return courseUrl;
    }

    public void setCourseUrl(String courseUrl) {
        this.courseUrl = courseUrl;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getCourseContent() {
        return courseContent;
    }

    public void setCourseContent(String courseContent) {
        this.courseContent = courseContent;
    }

    public String getCourseLevel() {
        return courseLevel;
    }

    public void setCourseLevel(String courseLevel) {
        this.courseLevel = courseLevel;
    }

    public Integer getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Integer isPublic) {
        this.isPublic = isPublic;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Timestamp getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Timestamp updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getCarouselImg() {
        return carouselImg;
    }

    public void setCarouselImg(String carouselImg) {
        this.carouselImg = carouselImg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurCourse curCourse = (CurCourse) o;
        return id == curCourse.id && Objects.equals(courseTypeId, curCourse.courseTypeId) && Objects.equals(courseName, curCourse.courseName) && Objects.equals(courseNumber, curCourse.courseNumber) && Objects.equals(description, curCourse.description) && Objects.equals(courseUrl, curCourse.courseUrl) && Objects.equals(pictureUrl, curCourse.pictureUrl) && Objects.equals(courseContent, curCourse.courseContent) && Objects.equals(courseLevel, curCourse.courseLevel) && Objects.equals(isPublic, curCourse.isPublic) && Objects.equals(creater, curCourse.creater) && Objects.equals(createdTime, curCourse.createdTime) && Objects.equals(updater, curCourse.updater) && Objects.equals(updatedTime, curCourse.updatedTime) && Objects.equals(carouselImg, curCourse.carouselImg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseTypeId, courseName, courseNumber, description, courseUrl, pictureUrl, courseContent, courseLevel, isPublic, creater, createdTime, updater, updatedTime, carouselImg);
    }
}
