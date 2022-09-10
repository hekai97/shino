package com.hekai.backend.controller.backstage;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.dto.StoreDto;
import com.hekai.backend.entity.EmployeeUser;
import com.hekai.backend.entity.Store;
import com.hekai.backend.service.StoreService;
import com.hekai.backend.utils.ConstUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/admin/store")
public class AdminStoreController {
    @Autowired
    private StoreService storeService;
    @RequestMapping(value = "/getStoreList",method = RequestMethod.GET)
    public ServerResponse<List<StoreDto>> getStoreList(){
        return storeService.getStoreList();
    }
    @RequestMapping(value = "/createStore",method = RequestMethod.POST)
    public ServerResponse<StoreDto> createStore(HttpSession httpSession,@RequestBody Store store){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return storeService.createStore(store);
    }
    @RequestMapping(value = "/updateStoreInfo",method = RequestMethod.POST)
    public ServerResponse<StoreDto> updateStoreInfo(HttpSession httpSession,@RequestBody Store store){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return storeService.updateStoreInfo(store);
    }
    @RequestMapping(value = "/deleteStore",method = RequestMethod.POST)
    public ServerResponse<String> deleteStore(HttpSession httpSession,@RequestParam Integer storeId){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return storeService.deleteStore(storeId);
    }

}
