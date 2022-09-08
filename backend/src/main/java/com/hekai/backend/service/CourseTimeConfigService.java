package com.hekai.backend.service;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.entity.CourseTimeConfig;

/**
 * 课程时间配置服务
 *
 * @author 17316
 * @date 2022/09/06
 */
public interface CourseTimeConfigService {
    /**
     * 得到课程时间配置
     *
     * @return {@link ServerResponse}<{@link CourseTimeConfig}>
     */
    ServerResponse<CourseTimeConfig> getCourseTimeConfig();
}
