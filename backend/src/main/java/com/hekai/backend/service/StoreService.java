package com.hekai.backend.service;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.StoreDto;
import com.hekai.backend.entity.Store;

import java.util.List;

public interface StoreService {
    ServerResponse<List<StoreDto>> getStoreList();

    /**
     * 得到存储,存储数字
     *
     * @param storeNumber 商店数量
     * @return {@link ServerResponse}<{@link Store}>
     */
    ServerResponse<StoreDto> getStoreByStoreNumber(String storeNumber);

    ServerResponse<StoreDto> createStore(Store store);

    ServerResponse<StoreDto> updateStoreInfo(Store store);

    ServerResponse<String> deleteStore(Integer storeId);
}
