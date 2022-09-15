package com.hekai.backend.controller.common;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.entity.EmployeeUser;
import com.hekai.backend.entity.Suggestion;
import com.hekai.backend.service.SuggestService;
import com.hekai.backend.utils.ConstUtil;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/suggest")
public class CommonSuggestController {
    @Autowired
    private SuggestService suggestService;
    @RequestMapping(value = "/createSuggest",method = RequestMethod.POST)
    public ServerResponse<String> createSuggest(@Parameter String phone,@Parameter String question,@Parameter String description){
        return suggestService.createSuggest(phone,question,description);
    }
    @RequestMapping(value = "/getAllSuggest",method = RequestMethod.GET)
    public ServerResponse<List<Suggestion>> getAllSuggest(HttpSession httpSession){
        EmployeeUser employeeUser=(EmployeeUser) httpSession.getAttribute(ConstUtil.EMPLOYEE_USER);
        if(employeeUser==null){
            return ServerResponse.createByErrorMessage("未登录！");
        }
        return suggestService.getAllSuggest();
    }
}
