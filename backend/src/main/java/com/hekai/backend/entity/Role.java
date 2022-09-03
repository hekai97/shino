package com.hekai.backend.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Role {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "creator")
    private String creator;
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
    @Column(name = "is_system_created_account")
    private Integer isSystemCreatedAccount;

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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
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

    public Integer getIsSystemCreatedAccount() {
        return isSystemCreatedAccount;
    }

    public void setIsSystemCreatedAccount(Integer isSystemCreatedAccount) {
        this.isSystemCreatedAccount = isSystemCreatedAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id == role.id && Objects.equals(name, role.name) && Objects.equals(creator, role.creator) && Objects.equals(createdTime, role.createdTime) && Objects.equals(updater, role.updater) && Objects.equals(updatedTime, role.updatedTime) && Objects.equals(isSystemCreatedAccount, role.isSystemCreatedAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, creator, createdTime, updater, updatedTime, isSystemCreatedAccount);
    }
}
