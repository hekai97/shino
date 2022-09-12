package com.hekai.backend.service;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.StoreDto;
import com.hekai.backend.entity.Store;

import java.util.List;

/**
 * 存储服务
 *
 * @author 17316
 * @date 2022/09/12
 */
public interface StoreService {
    /**
     * 获取存储列表
     *
     * @return {@link ServerResponse}<{@link List}<{@link StoreDto}>>
     */
    ServerResponse<List<StoreDto>> getStoreList();

    /**
     * 得到存储,存储数字
     *
     * @param storeNumber 商店数量
     * @return {@link ServerResponse}<{@link StoreDto}>
     */
    ServerResponse<StoreDto> getStoreByStoreNumber(String storeNumber);

    /**
     * 创建存储
     *
     * @param store 商店
     * @return {@link ServerResponse}<{@link StoreDto}>
     */
    ServerResponse<StoreDto> createStore(Store store);

    /**
     * 更新存储信息
     *
     * @param store 商店
     * @return {@link ServerResponse}<{@link StoreDto}>
     */
    ServerResponse<StoreDto> updateStoreInfo(Store store);

    /**
     * 删除存储
     *
     * @param storeId 存储id
     * @return {@link ServerResponse}<{@link String}>
     */
    ServerResponse<String> deleteStore(Integer storeId);
}
