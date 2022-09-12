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

/**
 * 管理存储控制器
 *
 * @author 17316
 * @date 2022/09/12
 */
@RestController
@RequestMapping(value = "/admin/store")
public class AdminStoreController {
    @Autowired
    private StoreService storeService;

    /**
     * 获取存储列表
     *
     * @return {@link ServerResponse}<{@link List}<{@link StoreDto}>>
     */
    @RequestMapping(value = "/getStoreList",method = RequestMethod.GET)
    public ServerResponse<List<StoreDto>> getStoreList(){
        return storeService.getStoreList();
    }

    /**
     * 创建存储
     *
     * @param httpSession http会话
     * @param store       商店
     * @return {@link ServerResponse}<{@link StoreDto}>
     */
    @RequestMapping(value = "/createStore",method = RequestMethod.POST)
    public ServerResponse<StoreDto> createStore(HttpSession httpSession,@RequestBody Store store){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return storeService.createStore(store);
    }

    /**
     * 更新存储信息
     *
     * @param httpSession http会话
     * @param store       商店
     * @return {@link ServerResponse}<{@link StoreDto}>
     */
    @RequestMapping(value = "/updateStoreInfo",method = RequestMethod.POST)
    public ServerResponse<StoreDto> updateStoreInfo(HttpSession httpSession,@RequestBody Store store){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return storeService.updateStoreInfo(store);
    }

    /**
     * 删除存储
     *
     * @param httpSession http会话
     * @param storeId     存储id
     * @return {@link ServerResponse}<{@link String}>
     */
    @RequestMapping(value = "/deleteStore",method = RequestMethod.POST)
    public ServerResponse<String> deleteStore(HttpSession httpSession,@RequestParam Integer storeId){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return storeService.deleteStore(storeId);
    }

}
