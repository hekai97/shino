package com.hekai.backend.service.imp;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.entity.CourseTimeConfig;
import com.hekai.backend.repository.CourseTimeConfigRepository;
import com.hekai.backend.service.CourseTimeConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseTimeConfigServiceImp implements CourseTimeConfigService {
    @Autowired
    private CourseTimeConfigRepository courseTimeConfigRepository;
    @Override
    public ServerResponse<CourseTimeConfig> getCourseTimeConfig() {
        return ServerResponse.createRespBySuccess(courseTimeConfigRepository.findAll().get(0));
    }
}
