package com.hekai.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "course_time_config", schema = "shinho", catalog = "")
public class CourseTimeConfig {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "course1StartTime")
    private String course1StartTime;
    @Basic
    @Column(name = "course1EndTime")
    private String course1EndTime;
    @Basic
    @Column(name = "course2StartTime")
    private String course2StartTime;
    @Basic
    @Column(name = "course2EndTime")
    private String course2EndTime;
    @Basic
    @Column(name = "course3StartTime")
    private String course3StartTime;
    @Basic
    @Column(name = "course3EndTime")
    private String course3EndTime;
    @Basic
    @Column(name = "course4StartTime")
    private String course4StartTime;
    @Basic
    @Column(name = "course4EndTime")
    private String course4EndTime;
    @Basic
    @Column(name = "ClassAttendance")
    private Integer classAttendance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse1StartTime() {
        return course1StartTime;
    }

    public void setCourse1StartTime(String course1StartTime) {
        this.course1StartTime = course1StartTime;
    }

    public String getCourse1EndTime() {
        return course1EndTime;
    }

    public void setCourse1EndTime(String course1EndTime) {
        this.course1EndTime = course1EndTime;
    }

    public String getCourse2StartTime() {
        return course2StartTime;
    }

    public void setCourse2StartTime(String course2StartTime) {
        this.course2StartTime = course2StartTime;
    }

    public String getCourse2EndTime() {
        return course2EndTime;
    }

    public void setCourse2EndTime(String course2EndTime) {
        this.course2EndTime = course2EndTime;
    }

    public String getCourse3StartTime() {
        return course3StartTime;
    }

    public void setCourse3StartTime(String course3StartTime) {
        this.course3StartTime = course3StartTime;
    }

    public String getCourse3EndTime() {
        return course3EndTime;
    }

    public void setCourse3EndTime(String course3EndTime) {
        this.course3EndTime = course3EndTime;
    }

    public String getCourse4StartTime() {
        return course4StartTime;
    }

    public void setCourse4StartTime(String course4StartTime) {
        this.course4StartTime = course4StartTime;
    }

    public String getCourse4EndTime() {
        return course4EndTime;
    }

    public void setCourse4EndTime(String course4EndTime) {
        this.course4EndTime = course4EndTime;
    }

    public Integer getClassAttendance() {
        return classAttendance;
    }

    public void setClassAttendance(Integer classAttendance) {
        this.classAttendance = classAttendance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseTimeConfig that = (CourseTimeConfig) o;
        return id == that.id && Objects.equals(course1StartTime, that.course1StartTime) && Objects.equals(course1EndTime, that.course1EndTime) && Objects.equals(course2StartTime, that.course2StartTime) && Objects.equals(course2EndTime, that.course2EndTime) && Objects.equals(course3StartTime, that.course3StartTime) && Objects.equals(course3EndTime, that.course3EndTime) && Objects.equals(course4StartTime, that.course4StartTime) && Objects.equals(course4EndTime, that.course4EndTime) && Objects.equals(classAttendance, that.classAttendance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, course1StartTime, course1EndTime, course2StartTime, course2EndTime, course3StartTime, course3EndTime, course4StartTime, course4EndTime, classAttendance);
    }
}
