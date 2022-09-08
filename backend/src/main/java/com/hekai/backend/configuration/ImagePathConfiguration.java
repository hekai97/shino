package com.hekai.backend.configuration;

import com.hekai.backend.utils.ConstUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ImagePathConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/course/**").addResourceLocations("file:"+ ConstUtil.COURSE_IMAGE_PATH);
        registry.addResourceHandler("/images/teachers/**").addResourceLocations("file:"+ ConstUtil.TEACHER_IMAGE_PATH);
        registry.addResourceHandler("/images/stores/**").addResourceLocations("file:"+ ConstUtil.STORE_IMAGE_PATH);
    }
}
