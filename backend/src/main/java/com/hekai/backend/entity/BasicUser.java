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
    @Column(name = "roleid")
    private Integer roleid;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "lastlogintime")
    private Timestamp lastlogintime;
    @Basic
    @Column(name = "enabled")
    private Byte enabled;
    @Basic
    @Column(name = "creater")
    private String creater;
    @Basic
    @Column(name = "createtime")
    private Timestamp createtime;
    @Basic
    @Column(name = "updater")
    private String updater;
    @Basic
    @Column(name = "updatetime")
    private Timestamp updatetime;
    @Basic
    @Column(name = "storeid")
    private Integer storeid;

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

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Timestamp lastlogintime) {
        this.lastlogintime = lastlogintime;
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

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
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
        BasicUser basicUser = (BasicUser) o;
        return id == basicUser.id && Objects.equals(num, basicUser.num) && Objects.equals(name, basicUser.name) && Objects.equals(roleid, basicUser.roleid) && Objects.equals(password, basicUser.password) && Objects.equals(lastlogintime, basicUser.lastlogintime) && Objects.equals(enabled, basicUser.enabled) && Objects.equals(creater, basicUser.creater) && Objects.equals(createtime, basicUser.createtime) && Objects.equals(updater, basicUser.updater) && Objects.equals(updatetime, basicUser.updatetime) && Objects.equals(storeid, basicUser.storeid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, num, name, roleid, password, lastlogintime, enabled, creater, createtime, updater, updatetime, storeid);
    }
}
