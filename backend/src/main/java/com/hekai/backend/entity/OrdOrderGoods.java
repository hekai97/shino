package com.hekai.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ord_order_goods", schema = "shinho", catalog = "")
public class OrdOrderGoods {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "coursedetailid")
    private Integer coursedetailid;
    @Basic
    @Column(name = "courseid")
    private Integer courseid;
    @Basic
    @Column(name = "writeoffcode")
    private String writeoffcode;
    @Basic
    @Column(name = "reserveid")
    private Integer reserveid;
    @Basic
    @Column(name = "coursetableid")
    private Integer coursetableid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCoursedetailid() {
        return coursedetailid;
    }

    public void setCoursedetailid(Integer coursedetailid) {
        this.coursedetailid = coursedetailid;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getWriteoffcode() {
        return writeoffcode;
    }

    public void setWriteoffcode(String writeoffcode) {
        this.writeoffcode = writeoffcode;
    }

    public Integer getReserveid() {
        return reserveid;
    }

    public void setReserveid(Integer reserveid) {
        this.reserveid = reserveid;
    }

    public Integer getCoursetableid() {
        return coursetableid;
    }

    public void setCoursetableid(Integer coursetableid) {
        this.coursetableid = coursetableid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdOrderGoods that = (OrdOrderGoods) o;
        return id == that.id && Objects.equals(coursedetailid, that.coursedetailid) && Objects.equals(courseid, that.courseid) && Objects.equals(writeoffcode, that.writeoffcode) && Objects.equals(reserveid, that.reserveid) && Objects.equals(coursetableid, that.coursetableid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, coursedetailid, courseid, writeoffcode, reserveid, coursetableid);
    }
}
