package com.hekai.backend.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Course {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "course_category_id")
    private Integer courseCategoryId;
    @Basic
    @Column(name = "course_name")
    private String courseName;
    @Basic
    @Column(name = "course_number")
    private String courseNumber;
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
    @Column(name = "creator")
    private String creator;
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

    public Integer getCourseCategoryId() {
        return courseCategoryId;
    }

    public void setCourseCategoryId(Integer courseCategoryId) {
        this.courseCategoryId = courseCategoryId;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
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
        Course course = (Course) o;
        return id == course.id && Objects.equals(courseCategoryId, course.courseCategoryId) && Objects.equals(courseName, course.courseName) && Objects.equals(courseNumber, course.courseNumber) && Objects.equals(courseTypeId, course.courseTypeId) && Objects.equals(coursePrice, course.coursePrice) && Objects.equals(coursePoints, course.coursePoints) && Objects.equals(slidePosition, course.slidePosition) && Objects.equals(description, course.description) && Objects.equals(courseUrl, course.courseUrl) && Objects.equals(pictureUrl, course.pictureUrl) && Objects.equals(courseContent, course.courseContent) && Objects.equals(courseLevel, course.courseLevel) && Objects.equals(isPublic, course.isPublic) && Objects.equals(creator, course.creator) && Objects.equals(createdTime, course.createdTime) && Objects.equals(updater, course.updater) && Objects.equals(updatedTime, course.updatedTime) && Objects.equals(carouselImg, course.carouselImg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseCategoryId, courseName, courseNumber, courseTypeId, coursePrice, coursePoints, slidePosition, description, courseUrl, pictureUrl, courseContent, courseLevel, isPublic, creator, createdTime, updater, updatedTime, carouselImg);
    }
}
