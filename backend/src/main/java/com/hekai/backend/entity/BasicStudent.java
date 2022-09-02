package com.hekai.backend.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "basic_student", schema = "shinho", catalog = "")
public class BasicStudent {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "nick")
    private String nick;
    @Basic
    @Column(name = "openid")
    private String openid;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "sex")
    private String sex;
    @Basic
    @Column(name = "birthday")
    private Date birthday;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "picture")
    private String picture;
    @Basic
    @Column(name = "registertime")
    private Timestamp registertime;
    @Basic
    @Column(name = "registerway")
    private String registerway;
    @Basic
    @Column(name = "status")
    private Integer status;
    @Basic
    @Column(name = "lastlogintime")
    private Timestamp lastlogintime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Timestamp getRegistertime() {
        return registertime;
    }

    public void setRegistertime(Timestamp registertime) {
        this.registertime = registertime;
    }

    public String getRegisterway() {
        return registerway;
    }

    public void setRegisterway(String registerway) {
        this.registerway = registerway;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Timestamp lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicStudent that = (BasicStudent) o;
        return id == that.id && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(nick, that.nick) && Objects.equals(openid, that.openid) && Objects.equals(name, that.name) && Objects.equals(phone, that.phone) && Objects.equals(address, that.address) && Objects.equals(sex, that.sex) && Objects.equals(birthday, that.birthday) && Objects.equals(email, that.email) && Objects.equals(picture, that.picture) && Objects.equals(registertime, that.registertime) && Objects.equals(registerway, that.registerway) && Objects.equals(status, that.status) && Objects.equals(lastlogintime, that.lastlogintime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, nick, openid, name, phone, address, sex, birthday, email, picture, registertime, registerway, status, lastlogintime);
    }
}
