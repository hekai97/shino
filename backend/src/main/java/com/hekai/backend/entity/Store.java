package com.hekai.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Store {
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
        Store store = (Store) o;
        return id == store.id && Objects.equals(storeNumber, store.storeNumber) && Objects.equals(storeName, store.storeName) && Objects.equals(type, store.type) && Objects.equals(storeManagerId, store.storeManagerId) && Objects.equals(address, store.address) && Objects.equals(pictureUrl, store.pictureUrl) && Objects.equals(summary, store.summary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, storeNumber, storeName, type, storeManagerId, address, pictureUrl, summary);
    }
}
