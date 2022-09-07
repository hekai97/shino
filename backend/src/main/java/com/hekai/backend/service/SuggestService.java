package com.hekai.backend.service;

import com.hekai.backend.common.ServerResponse;

public interface SuggestService {
    ServerResponse<String> createSuggest(String phone, String question, String description);
}
