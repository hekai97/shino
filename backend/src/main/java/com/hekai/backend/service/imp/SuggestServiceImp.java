package com.hekai.backend.service.imp;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.entity.Suggestion;
import com.hekai.backend.repository.SuggestionRepository;
import com.hekai.backend.service.SuggestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class SuggestServiceImp implements SuggestService {
    @Autowired
    private SuggestionRepository suggestionRepository;
    @Override
    public ServerResponse<String> createSuggest(Suggestion suggestion) {
        if(suggestion.getPhone()==null||suggestion.getPhone().equals("")){
            return ServerResponse.createByErrorMessage("手机号不能为空！");
        }
        if(suggestion.getQuestion()==null||suggestion.getQuestion().equals("")) {
            return ServerResponse.createByErrorMessage("问题不能为空！");
        }
        if(suggestion.getDescription()==null||suggestion.getDescription().equals("")){
            return ServerResponse.createByErrorMessage("描述不能为空！");
        }
        suggestion.setCreateTime(new Timestamp(new Date().getTime()));
        suggestionRepository.save(suggestion);
        return ServerResponse.createRespBySuccess("提交成功！");
    }

    @Override
    public ServerResponse<List<Suggestion>> getAllSuggest() {
        List<Suggestion> suggestionList=suggestionRepository.findAll();
        return ServerResponse.createRespBySuccess(suggestionList);
    }
}
