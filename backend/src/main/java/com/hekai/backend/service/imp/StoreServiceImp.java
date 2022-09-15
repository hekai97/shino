package com.hekai.backend.service.imp;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.StoreDto;
import com.hekai.backend.entity.Store;
import com.hekai.backend.repository.EmployeeUserRepository;
import com.hekai.backend.repository.StoreRepository;
import com.hekai.backend.service.StoreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreServiceImp implements StoreService {
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private EmployeeUserRepository employeeUserRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ServerResponse<List<StoreDto>> getStoreList() {
        List<Store> storeList=storeRepository.findAll();
        List<StoreDto> storeDtoList=storeListToStoreDtoList(storeList);
        return ServerResponse.createRespBySuccess(storeDtoList);
    }

    @Override
    public ServerResponse<StoreDto> getStoreByStoreNumber(String storeNumber) {
        Store store=storeRepository.findStoreByStoreNumber(storeNumber);
        StoreDto storeDto=storeToStoreDto(store);
        return ServerResponse.createRespBySuccess(storeDto);
    }

    @Override
    public ServerResponse<StoreDto> createStore(Store store) {
        if(store.getStoreNumber()==null){
            return ServerResponse.createByErrorMessage("请输入门店编号！");
        }
        if(store.getStoreName()==null){
            return ServerResponse.createByErrorMessage("请输入门店名字！");
        }
        Store isExistStore=storeRepository.findStoreByStoreNumber(store.getStoreNumber());
        if(isExistStore!=null){
            return ServerResponse.createByErrorMessage("该门店已存在，请修改门店号！");
        }
        Store store1=storeRepository.save(store);
        StoreDto storeDto=storeToStoreDto(store1);
        return ServerResponse.createRespBySuccess(storeDto);
    }

    @Override
    public ServerResponse<StoreDto> updateStoreInfo(Store store) {
        Store store1=storeRepository.save(store);
        return ServerResponse.createRespBySuccess(storeToStoreDto(store1));
    }

    @Override
    public ServerResponse<String> deleteStore(Integer storeId) {
        Store store=storeRepository.findStoreById(storeId);
        storeRepository.delete(store);
        return ServerResponse.createRespBySuccessMessage("删除门店成功！");
    }

    private StoreDto storeToStoreDto(Store s){
        StoreDto storeDto=modelMapper.map(s,StoreDto.class);
        storeDto.setStoreManagerName(employeeUserRepository.findEmployeeUserById(s.getStoreManagerId()).getName());
        return storeDto;
    }
    private List<StoreDto> storeListToStoreDtoList(List<Store> storeList){
        List<StoreDto> storeDtoList=new ArrayList<>();
        for(Store s:storeList){
            storeDtoList.add(storeToStoreDto(s));
        }
        return storeDtoList;
    }
}
