package com.hekai.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_goods", schema = "my_shinho", catalog = "")
public class OrderGoods {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "course_id")
    private Integer courseId;

    @Basic
    @Column(name = "order_detail_id")
    private Integer orderDetailId;
    @Basic
    @Column(name = "write_off_code_number")
    private String writeOffCodeNumber;
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

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getWriteOffCodeNumber() {
        return writeOffCodeNumber;
    }

    public void setWriteOffCodeNumber(String writeOffCodeNumber) {
        this.writeOffCodeNumber = writeOffCodeNumber;
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
        OrderGoods that = (OrderGoods) o;
        return id == that.id && Objects.equals(courseId, that.courseId) && Objects.equals(writeOffCodeNumber, that.writeOffCodeNumber) && Objects.equals(reserveId, that.reserveId) && Objects.equals(courseTableId, that.courseTableId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseId, writeOffCodeNumber, reserveId, courseTableId);
    }
}
