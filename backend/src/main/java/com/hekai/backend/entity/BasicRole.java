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
    @Column(name = "createtime")
    private Timestamp createtime;
    @Basic
    @Column(name = "updater")
    private String updater;
    @Basic
    @Column(name = "updatetime")
    private Timestamp updatetime;
    @Basic
    @Column(name = "issysacct")
    private Integer issysacct;

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

    public Integer getIssysacct() {
        return issysacct;
    }

    public void setIssysacct(Integer issysacct) {
        this.issysacct = issysacct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicRole basicRole = (BasicRole) o;
        return id == basicRole.id && Objects.equals(name, basicRole.name) && Objects.equals(creater, basicRole.creater) && Objects.equals(createtime, basicRole.createtime) && Objects.equals(updater, basicRole.updater) && Objects.equals(updatetime, basicRole.updatetime) && Objects.equals(issysacct, basicRole.issysacct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, creater, createtime, updater, updatetime, issysacct);
    }
}
