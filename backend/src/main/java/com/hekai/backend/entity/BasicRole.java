package com.hekai.backend.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "basic_role", schema = "shinho", catalog = "")
public class BasicRole {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "creater")
    private String creater;
    @Basic
    @Column(name = "create_time")
    private Timestamp createTime;
    @Basic
    @Column(name = "updater")
    private String updater;
    @Basic
    @Column(name = "update_time")
    private Timestamp updateTime;
    @Basic
    @Column(name = "is_system_account")
    private Integer isSystemAccount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsSystemAccount() {
        return isSystemAccount;
    }

    public void setIsSystemAccount(Integer isSystemAccount) {
        this.isSystemAccount = isSystemAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicRole basicRole = (BasicRole) o;
        return id == basicRole.id && Objects.equals(name, basicRole.name) && Objects.equals(creater, basicRole.creater) && Objects.equals(createTime, basicRole.createTime) && Objects.equals(updater, basicRole.updater) && Objects.equals(updateTime, basicRole.updateTime) && Objects.equals(isSystemAccount, basicRole.isSystemAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, creater, createTime, updater, updateTime, isSystemAccount);
    }
}
