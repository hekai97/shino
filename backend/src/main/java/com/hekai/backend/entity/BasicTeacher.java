package com.hekai.backend.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "basic_teacher", schema = "shinho", catalog = "")
public class BasicTeacher {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "store_id")
    private Integer storeId;
    @Basic
    @Column(name = "num")
    private String num;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "birthday")
    private Date birthday;
    @Basic
    @Column(name = "sex")
    private String sex;
    @Basic
    @Column(name = "picture")
    private String picture;
    @Basic
    @Column(name = "employment_date")
    private Date employmentDate;
    @Basic
    @Column(name = "good_category")
    private String goodCategory;
    @Basic
    @Column(name = "entry_date")
    private Date entryDate;
    @Basic
    @Column(name = "leave_date")
    private Date leaveDate;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "feature")
    private String feature;
    @Basic
    @Column(name = "status")
    private Integer status;
    @Basic
    @Column(name = "created_date")
    private Date createdDate;
    @Basic
    @Column(name = "created_user")
    private Integer createdUser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public String getGoodCategory() {
        return goodCategory;
    }

    public void setGoodCategory(String goodCategory) {
        this.goodCategory = goodCategory;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(Integer createdUser) {
        this.createdUser = createdUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicTeacher that = (BasicTeacher) o;
        return id == that.id && Objects.equals(storeId, that.storeId) && Objects.equals(num, that.num) && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(phone, that.phone) && Objects.equals(email, that.email) && Objects.equals(birthday, that.birthday) && Objects.equals(sex, that.sex) && Objects.equals(picture, that.picture) && Objects.equals(employmentDate, that.employmentDate) && Objects.equals(goodCategory, that.goodCategory) && Objects.equals(entryDate, that.entryDate) && Objects.equals(leaveDate, that.leaveDate) && Objects.equals(description, that.description) && Objects.equals(feature, that.feature) && Objects.equals(status, that.status) && Objects.equals(createdDate, that.createdDate) && Objects.equals(createdUser, that.createdUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, storeId, num, name, address, phone, email, birthday, sex, picture, employmentDate, goodCategory, entryDate, leaveDate, description, feature, status, createdDate, createdUser);
    }
}
