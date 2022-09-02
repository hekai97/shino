package com.hekai.backend.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "login_log", schema = "shinho", catalog = "")
public class LoginLog {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "user_Id")
    private Integer userId;
    @Basic
    @Column(name = "login_date")
    private Timestamp loginDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Timestamp getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Timestamp loginDate) {
        this.loginDate = loginDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginLog loginLog = (LoginLog) o;
        return id == loginLog.id && Objects.equals(userId, loginLog.userId) && Objects.equals(loginDate, loginLog.loginDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, loginDate);
    }
}
