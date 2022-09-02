package com.hekai.backend.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "basic_user", schema = "shinho", catalog = "")
public class BasicUser {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "num")
    private String num;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "role_id")
    private Integer roleId;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "last_login_time")
    private Timestamp lastLoginTime;
    @Basic
    @Column(name = "enabled")
    private Byte enabled;
    @Basic
    @Column(name = "creater")
    private String creater;
    @Basic
    @Column(name = "created_time")
    private Timestamp createdTime;
    @Basic
    @Column(name = "updater")
    private String updater;
    @Basic
    @Column(name = "updated_time")
    private Timestamp updatedTime;
    @Basic
    @Column(name = "store_id")
    private Integer storeId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Byte getEnabled() {
        return enabled;
    }

    public void setEnabled(Byte enabled) {
        this.enabled = enabled;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Timestamp getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Timestamp updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicUser basicUser = (BasicUser) o;
        return id == basicUser.id && Objects.equals(num, basicUser.num) && Objects.equals(name, basicUser.name) && Objects.equals(roleId, basicUser.roleId) && Objects.equals(password, basicUser.password) && Objects.equals(lastLoginTime, basicUser.lastLoginTime) && Objects.equals(enabled, basicUser.enabled) && Objects.equals(creater, basicUser.creater) && Objects.equals(createdTime, basicUser.createdTime) && Objects.equals(updater, basicUser.updater) && Objects.equals(updatedTime, basicUser.updatedTime) && Objects.equals(storeId, basicUser.storeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, num, name, roleId, password, lastLoginTime, enabled, creater, createdTime, updater, updatedTime, storeId);
    }
}
