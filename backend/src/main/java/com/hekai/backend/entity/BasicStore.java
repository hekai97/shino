package com.hekai.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "basic_store", schema = "shinho", catalog = "")
public class BasicStore {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "storenum")
    private String storenum;
    @Basic
    @Column(name = "storename")
    private String storename;
    @Basic
    @Column(name = "type")
    private String type;
    @Basic
    @Column(name = "userid")
    private Integer userid;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "picurl")
    private String picurl;
    @Basic
    @Column(name = "summary")
    private String summary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStorenum() {
        return storenum;
    }

    public void setStorenum(String storenum) {
        this.storenum = storenum;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicStore that = (BasicStore) o;
        return id == that.id && Objects.equals(storenum, that.storenum) && Objects.equals(storename, that.storename) && Objects.equals(type, that.type) && Objects.equals(userid, that.userid) && Objects.equals(address, that.address) && Objects.equals(picurl, that.picurl) && Objects.equals(summary, that.summary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, storenum, storename, type, userid, address, picurl, summary);
    }
}
