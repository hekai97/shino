package com.hekai.backend.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "teacher",schema = "my_shinho")
public class Teacher {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "store_id")
    private Integer storeId;
    @Basic
    @Column(name = "number")
    private String number;
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
    @Column(name = "picture_url")
    private String pictureUrl;
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
    @Column(name = "created_user_number")
    private String createdUserNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
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

    public String getCreatedUserNumber() {
        return createdUserNumber;
    }

    public void setCreatedUserNumber(String createdUserNumber) {
        this.createdUserNumber = createdUserNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return id == teacher.id && Objects.equals(storeId, teacher.storeId) && Objects.equals(number, teacher.number) && Objects.equals(name, teacher.name) && Objects.equals(address, teacher.address) && Objects.equals(phone, teacher.phone) && Objects.equals(email, teacher.email) && Objects.equals(birthday, teacher.birthday) && Objects.equals(sex, teacher.sex) && Objects.equals(pictureUrl, teacher.pictureUrl) && Objects.equals(employmentDate, teacher.employmentDate) && Objects.equals(goodCategory, teacher.goodCategory) && Objects.equals(entryDate, teacher.entryDate) && Objects.equals(leaveDate, teacher.leaveDate) && Objects.equals(description, teacher.description) && Objects.equals(feature, teacher.feature) && Objects.equals(status, teacher.status) && Objects.equals(createdDate, teacher.createdDate) && Objects.equals(createdUserNumber, teacher.createdUserNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, storeId, number, name, address, phone, email, birthday, sex, pictureUrl, employmentDate, goodCategory, entryDate, leaveDate, description, feature, status, createdDate, createdUserNumber);
    }
}
