package com.hekai.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cur_rl_store_course", schema = "shinho", catalog = "")
public class CurRlStoreCourse {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "courseid")
    private Integer courseid;
    @Basic
    @Column(name = "storeid")
    private Integer storeid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public Integer getStoreid() {
        return storeid;
    }

    public void setStoreid(Integer storeid) {
        this.storeid = storeid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurRlStoreCourse that = (CurRlStoreCourse) o;
        return id == that.id && Objects.equals(courseid, that.courseid) && Objects.equals(storeid, that.storeid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseid, storeid);
    }
}
