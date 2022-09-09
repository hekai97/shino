package com.hekai.backend.controller.backstage;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.entity.EmployeeUser;
import com.hekai.backend.entity.Store;
import com.hekai.backend.service.CourseService;
import com.hekai.backend.utils.ConstUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/admin/store")
public class AdminStoreController {
    @Autowired
    private CourseService courseService;
    @RequestMapping(value = "/getStoreList",method = RequestMethod.GET)
    public ServerResponse<List<Store>> getStoreList(){
        return courseService.getStoreList();
    }
    @RequestMapping(value = "/createStore",method = RequestMethod.POST)
    public ServerResponse<Store> createStore(HttpSession httpSession, Store store){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return courseService.createStore(store);
    }
    @RequestMapping(value = "/updateStoreInfo",method = RequestMethod.POST)
    public ServerResponse<Store> updateStoreInfo(HttpSession httpSession, Store store){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return courseService.updateStoreInfo(store);
    }
    @RequestMapping(value = "/deleteStore",method = RequestMethod.POST)
    public ServerResponse<String> deleteStore(HttpSession httpSession, Integer storeId){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.ADMIN_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return courseService.deleteStore(storeId);
    }

}
