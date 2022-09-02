package com.hekai.backend.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Loginlog {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "userId")
    private Integer userId;
    @Basic
    @Column(name = "loginDate")
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
        Loginlog loginlog = (Loginlog) o;
        return id == loginlog.id && Objects.equals(userId, loginlog.userId) && Objects.equals(loginDate, loginlog.loginDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, loginDate);
    }
}
