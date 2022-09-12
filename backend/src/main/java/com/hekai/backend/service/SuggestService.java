package com.hekai.backend.service;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.entity.Suggestion;

import java.util.List;

/**
 * 建议服务
 *
 * @author 17316
 * @date 2022/09/12
 */
public interface SuggestService {
    /**
     * 创建显示
     *
     * @param phone       电话
     * @param question    问题
     * @param description 描述
     * @return {@link ServerResponse}<{@link String}>
     */
    ServerResponse<String> createSuggest(String phone, String question, String description);

    /**
     * 得到所有建议
     *
     * @return {@link ServerResponse}<{@link List}<{@link Suggestion}>>
     */
    ServerResponse<List<Suggestion>> getAllSuggest();
}
