package com.hekai.backend.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.hekai.backend.entity.Store} entity
 */
@Data
public class StoreDto implements Serializable {
    private int id;
    private String storeNumber;
    private String storeName;
    private String type;
    private Integer storeManagerId;
    private String storeManagerName;
    private String address;
    private String pictureUrl;
    private String summary;

    public String getStoreManagerName() {
        return storeManagerName;
    }

    public void setStoreManagerName(String storeManagerName) {
        this.storeManagerName = storeManagerName;
    }

}