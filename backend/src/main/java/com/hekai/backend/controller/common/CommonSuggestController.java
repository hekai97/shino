package com.hekai.backend.controller.common;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.service.SuggestService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/suggest")
public class CommonSuggestController {
    @Autowired
    private SuggestService suggestService;
    @RequestMapping(value = "/createSuggest",method = RequestMethod.GET)
    public ServerResponse<String> createSuggest(@Parameter String phone,@Parameter String question,@Parameter String description){
        return suggestService.createSuggest(phone,question,description);
    }
}
