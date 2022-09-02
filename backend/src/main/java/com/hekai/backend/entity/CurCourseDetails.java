package com.hekai.backend.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "cur_course_details", schema = "shinho", catalog = "")
public class CurCourseDetails {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "orderid")
    private Integer orderid;
    @Basic
    @Column(name = "courseid")
    private Integer courseid;
    @Basic
    @Column(name = "coursetypeid")
    private Integer coursetypeid;
    @Basic
    @Column(name = "price")
    private BigDecimal price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public Integer getCoursetypeid() {
        return coursetypeid;
    }

    public void setCoursetypeid(Integer coursetypeid) {
        this.coursetypeid = coursetypeid;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurCourseDetails that = (CurCourseDetails) o;
        return id == that.id && Objects.equals(orderid, that.orderid) && Objects.equals(courseid, that.courseid) && Objects.equals(coursetypeid, that.coursetypeid) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderid, courseid, coursetypeid, price);
    }
}
