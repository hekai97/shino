package com.hekai.backend.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "cur_rl_course_childcourse", schema = "shinho", catalog = "")
public class CurRlCourseChildcourse {
    @Basic
    @Column(name = "packageid")
    private Integer packageid;
    @Basic
    @Column(name = "childcourseid")
    private Integer childcourseid;

    public Integer getPackageid() {
        return packageid;
    }

    public void setPackageid(Integer packageid) {
        this.packageid = packageid;
    }

    public Integer getChildcourseid() {
        return childcourseid;
    }

    public void setChildcourseid(Integer childcourseid) {
        this.childcourseid = childcourseid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurRlCourseChildcourse that = (CurRlCourseChildcourse) o;
        return Objects.equals(packageid, that.packageid) && Objects.equals(childcourseid, that.childcourseid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(packageid, childcourseid);
    }
}
