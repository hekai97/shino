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
    public ServerResponse<String> createSuggest(String phone, String question, String description) {
        if(phone==null||phone.equals("")){
            return ServerResponse.createByErrorMessage("手机号不能为空！");
        }
        if(question==null||question.equals("")){
            return ServerResponse.createByErrorMessage("问题不能为空！");
        }
        Suggestion suggestion=new Suggestion();
        suggestion.setCreateTime(new Timestamp(new Date().getTime()));
        suggestion.setPhone(phone);
        suggestion.setQuestion(question);
        suggestion.setDescription(description);
        suggestionRepository.save(suggestion);
        return ServerResponse.createRespBySuccess("提交成功！");
    }

    @Override
    public ServerResponse<List<Suggestion>> getAllSuggest() {
        List<Suggestion> suggestionList=suggestionRepository.findAll();
        return ServerResponse.createRespBySuccess(suggestionList);
    }
}
