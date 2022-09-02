package com.hekai.backend.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "cur_course_table", schema = "shinho", catalog = "")
public class CurCourseTable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "storeid")
    private Integer storeid;
    @Basic
    @Column(name = "courseid")
    private Integer courseid;
    @Basic
    @Column(name = "instructorid")
    private Integer instructorid;
    @Basic
    @Column(name = "userid")
    private Integer userid;
    @Basic
    @Column(name = "createtime")
    private Timestamp createtime;
    @Basic
    @Column(name = "reservationdate")
    private Date reservationdate;
    @Basic
    @Column(name = "begintime")
    private Time begintime;
    @Basic
    @Column(name = "endtime")
    private Time endtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getStoreid() {
        return storeid;
    }

    public void setStoreid(Integer storeid) {
        this.storeid = storeid;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public Integer getInstructorid() {
        return instructorid;
    }

    public void setInstructorid(Integer instructorid) {
        this.instructorid = instructorid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Date getReservationdate() {
        return reservationdate;
    }

    public void setReservationdate(Date reservationdate) {
        this.reservationdate = reservationdate;
    }

    public Time getBegintime() {
        return begintime;
    }

    public void setBegintime(Time begintime) {
        this.begintime = begintime;
    }

    public Time getEndtime() {
        return endtime;
    }

    public void setEndtime(Time endtime) {
        this.endtime = endtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurCourseTable that = (CurCourseTable) o;
        return id == that.id && Objects.equals(storeid, that.storeid) && Objects.equals(courseid, that.courseid) && Objects.equals(instructorid, that.instructorid) && Objects.equals(userid, that.userid) && Objects.equals(createtime, that.createtime) && Objects.equals(reservationdate, that.reservationdate) && Objects.equals(begintime, that.begintime) && Objects.equals(endtime, that.endtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, storeid, courseid, instructorid, userid, createtime, reservationdate, begintime, endtime);
    }
}
