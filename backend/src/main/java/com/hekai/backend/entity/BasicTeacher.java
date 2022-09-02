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
    @Column(name = "storeid")
    private Integer storeid;
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
    @Column(name = "employmentdate")
    private Date employmentdate;
    @Basic
    @Column(name = "goodcategory")
    private String goodcategory;
    @Basic
    @Column(name = "entrydate")
    private Date entrydate;
    @Basic
    @Column(name = "leavedate")
    private Date leavedate;
    @Basic
    @Column(name = "discription")
    private String discription;
    @Basic
    @Column(name = "feature")
    private String feature;
    @Basic
    @Column(name = "status")
    private Integer status;
    @Basic
    @Column(name = "createDate")
    private Date createDate;
    @Basic
    @Column(name = "createUser")
    private Integer createUser;

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

    public Date getEmploymentdate() {
        return employmentdate;
    }

    public void setEmploymentdate(Date employmentdate) {
        this.employmentdate = employmentdate;
    }

    public String getGoodcategory() {
        return goodcategory;
    }

    public void setGoodcategory(String goodcategory) {
        this.goodcategory = goodcategory;
    }

    public Date getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(Date entrydate) {
        this.entrydate = entrydate;
    }

    public Date getLeavedate() {
        return leavedate;
    }

    public void setLeavedate(Date leavedate) {
        this.leavedate = leavedate;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicTeacher that = (BasicTeacher) o;
        return id == that.id && Objects.equals(storeid, that.storeid) && Objects.equals(num, that.num) && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(phone, that.phone) && Objects.equals(email, that.email) && Objects.equals(birthday, that.birthday) && Objects.equals(sex, that.sex) && Objects.equals(picture, that.picture) && Objects.equals(employmentdate, that.employmentdate) && Objects.equals(goodcategory, that.goodcategory) && Objects.equals(entrydate, that.entrydate) && Objects.equals(leavedate, that.leavedate) && Objects.equals(discription, that.discription) && Objects.equals(feature, that.feature) && Objects.equals(status, that.status) && Objects.equals(createDate, that.createDate) && Objects.equals(createUser, that.createUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, storeid, num, name, address, phone, email, birthday, sex, picture, employmentdate, goodcategory, entrydate, leavedate, discription, feature, status, createDate, createUser);
    }
}
