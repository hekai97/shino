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
    @Column(name = "store_number")
    private String storeNumber;
    @Basic
    @Column(name = "store_name")
    private String storeName;
    @Basic
    @Column(name = "type")
    private String type;
    @Basic
    @Column(name = "store_manager_id")
    private Integer storeManagerId;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "picture_url")
    private String pictureUrl;
    @Basic
    @Column(name = "summary")
    private String summary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(String storeNumber) {
        this.storeNumber = storeNumber;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getStoreManagerId() {
        return storeManagerId;
    }

    public void setStoreManagerId(Integer storeManagerId) {
        this.storeManagerId = storeManagerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
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
        return id == that.id && Objects.equals(storeNumber, that.storeNumber) && Objects.equals(storeName, that.storeName) && Objects.equals(type, that.type) && Objects.equals(storeManagerId, that.storeManagerId) && Objects.equals(address, that.address) && Objects.equals(pictureUrl, that.pictureUrl) && Objects.equals(summary, that.summary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, storeNumber, storeName, type, storeManagerId, address, pictureUrl, summary);
    }
}
