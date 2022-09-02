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
    @Column(name = "course_detail_id")
    private Integer courseDetailId;
    @Basic
    @Column(name = "course_id")
    private Integer courseId;
    @Basic
    @Column(name = "write_off_code")
    private String writeOffCode;
    @Basic
    @Column(name = "reserve_id")
    private Integer reserveId;
    @Basic
    @Column(name = "course_table_id")
    private Integer courseTableId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCourseDetailId() {
        return courseDetailId;
    }

    public void setCourseDetailId(Integer courseDetailId) {
        this.courseDetailId = courseDetailId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getWriteOffCode() {
        return writeOffCode;
    }

    public void setWriteOffCode(String writeOffCode) {
        this.writeOffCode = writeOffCode;
    }

    public Integer getReserveId() {
        return reserveId;
    }

    public void setReserveId(Integer reserveId) {
        this.reserveId = reserveId;
    }

    public Integer getCourseTableId() {
        return courseTableId;
    }

    public void setCourseTableId(Integer courseTableId) {
        this.courseTableId = courseTableId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdOrderGoods that = (OrdOrderGoods) o;
        return id == that.id && Objects.equals(courseDetailId, that.courseDetailId) && Objects.equals(courseId, that.courseId) && Objects.equals(writeOffCode, that.writeOffCode) && Objects.equals(reserveId, that.reserveId) && Objects.equals(courseTableId, that.courseTableId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseDetailId, courseId, writeOffCode, reserveId, courseTableId);
    }
}
